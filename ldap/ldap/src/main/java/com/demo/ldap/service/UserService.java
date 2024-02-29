package com.demo.ldap.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.ldap.dto.UserDto;
import com.demo.ldap.entity.Role;
import com.demo.ldap.entity.User;
import com.demo.ldap.sql.repository.LdapRepository;
import com.demo.ldap.sql.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {

		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private LdapRepository ldapRepository;
		
			
		public void saveUserDetails(UserDto user) throws Exception {
			if(user==null) {
				throw new Exception("User Information is not valid");
			}
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User loggedInUserDetails = (User)authentication.getPrincipal();
			
			if(user.getUserId()==null) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				if(user.getPassword()==null) {
					throw new Exception("Password should not be null");
				}
				User existingUserDetails = userRepository.findByUserName(user.getUserName());
				if(existingUserDetails!=null) {
					throw new Exception("User already exist");
				}
				
				String encryptedPassword = encoder.encode(user.getPassword());
				User userDetails = convertDtoToUser(user,encryptedPassword,loggedInUserDetails);
				userRepository.save(userDetails);
				
				// save user to LDAP
				ldapRepository.create(user.getUserName(),user.getPassword());
			}
			else {
				Optional<User> userDetailOptional = userRepository.findById(user.getUserId());
				if(userDetailOptional.isPresent()) {
					User userDetail = userDetailOptional.get();
					if(!userDetail.getUserName().equals(user.getUserName())) {
						//Edit
						ldapRepository.modifyLDAPUser(user.getUserName(),userDetail.getUserName());
					}
					userDetail.setModifiedDate(LocalDateTime.now());
					userDetail.setModifiedBy(loggedInUserDetails.getUserId().intValue());
					userDetail.setUserName(user.getUserName());
					userRepository.save(userDetail);
					
					
				}
			}
		}

		private User convertDtoToUser(UserDto user, String encryptedPassword,User loggedInUserDetails ) {
			User userDetails = new User();
			userDetails.setUserName(user.getUserName());
			userDetails.setEmailId(user.getEmailId());
			userDetails.setPassword(encryptedPassword);
			userDetails.setIdentity(UUID.randomUUID().toString());
			userDetails.setCreatedDate(LocalDateTime.now());
			userDetails.setCreatedBy(loggedInUserDetails.getUserId().intValue());
			userDetails.setModifiedDate(LocalDateTime.now());
			userDetails.setModifiedBy(loggedInUserDetails.getUserId().intValue());
			
			
			List<Role> roleList = user.getRoles().stream()
							.map(role->setRoles(role, userDetails)).toList();
			userDetails.setRoleList(roleList);
		
			return userDetails;
			
		}
		
		private Role setRoles(String roleName,User userDetails){
			Role role = new Role();
			role.setCreatedDate(LocalDateTime.now());
			role.setCreatedBy(userDetails.getCreatedBy());
			role.setModifiedDate(LocalDateTime.now());
			role.setModifiedBy(userDetails.getModifiedBy());
			role.setRoleName(roleName);
			role.setUser(userDetails);
			return role;
		}
		
			
		
//	    private String digestSHA(final String password) {
//	    	String base64;
//	    	try {
//	    		MessageDigest digest = MessageDigest.getInstance("SHA");
//	    		digest.update(password.getBytes());
//	    		base64 = Base64
//	    				.getEncoder()
//	    				.encodeToString(digest.digest());
//	    	} catch (NoSuchAlgorithmException e) {
//	    		throw new RuntimeException(e);
//	    	}
//	    	return "{SHA}" + base64;
//	    }
	    
	    
}