package com.learn.security.jwt.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JwtSecurityConfiguration {
	
	@Bean	
	public KeyPair keyPair() {
		try {
		    var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			return keyPairGenerator.generateKeyPair();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Bean
	public RSAKey RSAkeyPairGenerator(KeyPair keypair) {
		return new RSAKey
				   .Builder((RSAPublicKey)keypair.getPublic())
				   .privateKey(keypair.getPrivate())
				   .keyID(UUID.randomUUID().toString())
				   .build();
	}
	
	@Bean
	public JWKSource<SecurityContext> getJWKSource(RSAKey rsaKey){
		var jwkSet = new JWKSet(rsaKey);
	    JWKSource<SecurityContext> jwkSource=(jwkSelector,context)->jwkSelector.select(jwkSet);
	    return jwkSource;
	}
	
	@Bean
	public JwtDecoder JWTDecoder(RSAKey rsakey) throws JOSEException {
		return NimbusJwtDecoder.withPublicKey(rsakey.toRSAPublicKey())
						.build();
	}
	
	@Bean
	public JwtEncoder JWTEncoder(JWKSource<SecurityContext> getJWKSource) {
		return new NimbusJwtEncoder(getJWKSource);
	}
	
	
}

