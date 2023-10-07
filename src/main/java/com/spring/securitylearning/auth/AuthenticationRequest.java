package com.spring.securitylearning.auth;

public record AuthenticationRequest(
	String email,
	String password
) {
}
