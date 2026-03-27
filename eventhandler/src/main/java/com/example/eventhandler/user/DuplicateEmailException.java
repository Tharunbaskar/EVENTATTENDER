package com.example.eventhandler.user;

public class DuplicateEmailException extends RuntimeException {

	public DuplicateEmailException(String email) {
		super("User email already exists: " + email);
	}
}
