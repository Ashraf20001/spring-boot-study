package com.learn.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	
	private enum ROLES{ADMIN,USER}

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		http.headers().frameOptions().sameOrigin();
		http.csrf(csrf->csrf.disable());
//		http.oauth2ResourceServer(oauth->oauth.jwt(Customizer.withDefaults()));
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var employeeUser = userGenerator("ashraf","Ashraf@123",ROLES.USER);
		var adminUser = userGenerator("saif","Saif@123",ROLES.ADMIN);
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(getDataSource());
		jdbcUserDetailsManager.createUser(employeeUser);
		jdbcUserDetailsManager.createUser(adminUser);
		return jdbcUserDetailsManager;
	}

	@Bean
	public DataSource getDataSource() {
		 return new EmbeddedDatabaseBuilder()
				 	.setType(EmbeddedDatabaseType.H2)
				 	.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				 	.build();
	}
	
	private UserDetails userGenerator(String username, String password, ROLES roles) {
		return User.builder()
			.username(username)
			.password(password)
			.passwordEncoder(string->getPasswordEncoder().encode(string))
			.roles(roles.toString())
			.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

