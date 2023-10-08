package com.spring.securitylearning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtConfig(
	String secretKey,
	long expirationSeconds
) {
}
