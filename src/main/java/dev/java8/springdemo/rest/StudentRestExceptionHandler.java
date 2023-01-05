package dev.java8.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class StudentRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles generic exceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
