package com.spring.securitylearning.auth;

public record RegisterRequest(
	String firstname,
	String lastname,
	String email,
	String password
) {
}
