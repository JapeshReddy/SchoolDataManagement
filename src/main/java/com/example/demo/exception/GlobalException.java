package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.ResponseStructure;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleResourceNotFoundException(ResourceNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(),
				"Resource Not Found", LocalDateTime.now(), e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ResponseStructure<String>> handleResourceAlreadyExistsException(
			ResourceAlreadyExistsException e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.CONFLICT.value(),
				"Resource Already Exists", LocalDateTime.now(), e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseStructure<String>> handleUnKnownException(RuntimeException e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal Server Issue", LocalDateTime.now(), e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentAndSubjectNotInSameClassException.class)
	public ResponseEntity<ResponseStructure<String>> handleStudentAndSubjectNotInSameClassException(
			StudentAndSubjectNotInSameClassException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(),
				"Validation Error", LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}

}
