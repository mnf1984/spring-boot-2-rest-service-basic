package com.in28minutes.springboot.rest.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentBadRequestException extends Exception {

	public StudentBadRequestException(String message) {
		super(message);
	}

}
