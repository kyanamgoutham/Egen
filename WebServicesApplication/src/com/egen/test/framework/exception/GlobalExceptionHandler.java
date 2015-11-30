package com.egen.test.framework.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.egen.test.framework.response.failure.FailureResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(WebRequest request, Exception e) {
		FailureResponse failureResponse = new FailureResponse();
		failureResponse.setCode("X00000");
		failureResponse.setDeveloperMessage(e.getMessage());
		failureResponse.setUserMessage("System Error");
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(e, failureResponse, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

}
