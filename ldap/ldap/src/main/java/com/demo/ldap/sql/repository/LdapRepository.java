package com.demo.ldap.sql.repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class LdapRepository {
		
	@Autowired
	private LdapTemplate ldapTemplate;
	
	public void create(String username, String password) {
	    Name dn = LdapNameBuilder
	      .newInstance()
	      .add("ou","system")
	      .add("ou", "users")
	      .add("cn", username)
	      .build();
	    DirContextAdapter context = new DirContextAdapter(dn);

	    context.setAttributeValues(
	      "objectclass", 
	      new String[] 
	        { "top", 
	          "person", 
	          "organizationalPerson", 
	          "inetOrgPerson" });
	    context.setAttributeValue("cn", username);
	    context.setAttributeValue("sn", username);
	    context.setAttributeValue
	      ("userPassword", digestSSHA(password));

	    ldapTemplate.bind(context);
	}
	
	public void modifyLDAPUser(String modifiedUserName,String username) {
		// Build the DN with the old username
	    Name oldDn = LdapNameBuilder.newInstance()
	    		.add("ou","system")
	            .add("ou", "users")
	            .add("cn", username)
	            .build();

	    // Build the DN with the new username
	    Name newDn = LdapNameBuilder.newInstance()
	    		.add("ou","system")
	            .add("ou", "users")
	            .add("cn", modifiedUserName)
	            .build();

	    // Rename the entry (modify the cn attribute)
	    ldapTemplate.rename(oldDn, newDn);

	    // Now, modify other attributes (e.g., sn)
	    Name dn = LdapNameBuilder.newInstance()
	    		.add("ou","system")
	            .add("ou", "users")
	            .add("cn", modifiedUserName)
	            .build();
	    
	    DirContextOperations context = ldapTemplate.lookupContext(dn);
	    context.setAttributeValue("sn", modifiedUserName);
	    
	    // Perform the modify operation
	    ldapTemplate.modifyAttributes(dn, context.getModificationItems());
	    
	    
//	    Name oldDn = LdapNameBuilder.newInstance()
//	    		.add("ou","system")
//	            .add("ou", "users")
//	            .add("cn", username)
//	            .build();
//
//	    // Build the DN with the new username
//	    Name newDn = LdapNameBuilder.newInstance()
//	    		.add("ou","system")
//	            .add("ou", "users")
//	            .add("cn", modifiedUserName)
//	            .build();
//
//	    // Lookup the entry
//	    DirContextOperations context = ldapTemplate.lookupContext(oldDn);
//
//	    // Modify the DN and other attributes
//	    context.setAttributeValue("cn", modifiedUserName);
//	    context.setAttributeValue("sn", modifiedUserName);
//
//	    // Perform the modify operation with the new DN
//	    ldapTemplate.rename(oldDn, newDn);
	}
	
	private String digestSSHA(final String password) {
        String base64;
        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[8];
            random.nextBytes(salt);

            // Combine password and salt
            byte[] combined = new byte[password.getBytes().length + salt.length];
            System.arraycopy(password.getBytes(), 0, combined, 0, password.getBytes().length);
            System.arraycopy(salt, 0, combined, password.getBytes().length, salt.length);

            // Hash the combined value using SHA-1
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = digest.digest(combined);

            // Combine hashed value and salt
            byte[] hashedWithSalt = new byte[hashedBytes.length + salt.length];
            System.arraycopy(hashedBytes, 0, hashedWithSalt, 0, hashedBytes.length);
            System.arraycopy(salt, 0, hashedWithSalt, hashedBytes.length, salt.length);

            // Encode the combined value in Base64
            base64 = Base64.getEncoder().encodeToString(hashedWithSalt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return "{SSHA}" + base64;
    }

}
