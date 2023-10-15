package com.learn.security.jwt.config;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class JWTResource {
		
//	@Autowired
	private JwtEncoder jwtEncoder;
	
	public JWTResource(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}


	@PostMapping(path = "authenticate")
	public JWTResponse getJwtResponse(Authentication authentication) {
		return new JWTResponse(generateToken(authentication));
	}


	private String generateToken(Authentication authentication) {
		var claimSet =	JwtClaimsSet.builder()
						.issuer("ashraf")
						.issuedAt(Instant.now())
						.subject(authentication.getName())
						.claim("scope",getClaimScope(authentication))
						.expiresAt(Instant.now().plusSeconds(3600))
						.build();
		return jwtEncoder.encode(JwtEncoderParameters.from(claimSet)).getTokenValue();
	}


	private String getClaimScope(Authentication authentication) {
		String authorities = authentication.getAuthorities()
					.stream().map(authority->authority.getAuthority()).collect(Collectors.joining(" "));
		return authorities;
	}
	
}

record JWTResponse(String token) {}