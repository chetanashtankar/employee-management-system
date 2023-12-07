package com.te.ems.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.exception.EmployeeNotFoundException;
import com.te.ems.response.ErrorResponse;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handler(RuntimeException exception) {
		return ResponseEntity.<ErrorResponse>ok().body(ErrorResponse.builder()
				.error(exception.getMessage())
				.timestamp(LocalDateTime.now())
				.build());
	}
}
