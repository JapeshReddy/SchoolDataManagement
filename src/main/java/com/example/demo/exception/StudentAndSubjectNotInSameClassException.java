package com.example.demo.exception;

public class StudentAndSubjectNotInSameClassException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentAndSubjectNotInSameClassException() {
	}

	public StudentAndSubjectNotInSameClassException(String message) {

		super(message);

	}

}
