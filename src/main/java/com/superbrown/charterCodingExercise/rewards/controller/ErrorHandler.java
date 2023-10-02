package com.superbrown.charterCodingExercise.rewards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception ex) {

		ex.printStackTrace();
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("An error occurred");
	}
}
