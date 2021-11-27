package com.ids.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ids.entity.Authority;
import com.ids.entity.User;
import com.ids.model.UsernamePassword;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenProvider tokenProvider;

	public String authenticate(UsernamePassword login) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					login.getUsername(), login.getPassword());

			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.createToken(authentication, login.getRememberMe());
			return token;
		} catch (BadCredentialsException e) {
			log.warn("Erreur auth : {}", e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "login.password.incorect");
		}
	}

	public String signup(User user) {
        String authorities = user.getAuthorities().stream()
    			.map(Authority::getName)
    			.collect(Collectors.joining(","));
		return tokenProvider.createToken(user.getUsername(), authorities, true);
	}
}
