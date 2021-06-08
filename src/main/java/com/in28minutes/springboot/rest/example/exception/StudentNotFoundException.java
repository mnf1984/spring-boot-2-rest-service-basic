package com.in28minutes.springboot.rest.example.exception;


public class StudentNotFoundException extends Exception {

	public StudentNotFoundException(String message) {
		super(message);
	}

}
