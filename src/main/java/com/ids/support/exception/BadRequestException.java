package com.ids.support.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Spring 5
public class BadRequestException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super(HttpStatus.BAD_REQUEST, "io.bad_request");
	}

	public BadRequestException(String reason) {
		super(HttpStatus.BAD_REQUEST, reason);
	}

	public BadRequestException(HttpStatus status, String reason, Throwable cause) {
		super(status, reason, cause);
	}

}
