package com.spring.securitylearning.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.securitylearning.config.JwtService;
import com.spring.securitylearning.user.Role;
import com.spring.securitylearning.user.User;
import com.spring.securitylearning.user.UserRepository;
import com.spring.securitylearning.user.UserSecurity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		User user = User.builder()
			.firstname(request.firstname())
			.lastname(request.lastname())
			.email(request.email())
			.password(passwordEncoder.encode(request.password()))
			.role(Role.USER)
			.build();
		userRepository.save(user);
		String jwtToken = jwtService.generateToken(new UserSecurity(user));
		return new AuthenticationResponse(jwtToken);
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				request.email(),
				request.password()
			)
		);
		User user = userRepository.findByEmail(request.email())
			.orElseThrow();
		String jwtToken = jwtService.generateToken(new UserSecurity(user));
		return new AuthenticationResponse(jwtToken);
	}
}
