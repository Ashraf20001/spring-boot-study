package com.learn.security.jwt.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

//@Configuration
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

