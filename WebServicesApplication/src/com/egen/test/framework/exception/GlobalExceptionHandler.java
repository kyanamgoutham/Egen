package com.egen.test.framework.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.resource.Resource;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.response.failure.FailureResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends Resource {

	@ExceptionHandler(Exception.class)
	@Produces(MediaType.APPLICATION_JSON)
	public IResponse handleException(IRequest request, Exception e) {
		FailureResponse failureResponse = new FailureResponse();
		failureResponse.setCode("X00000");
		failureResponse.setDeveloperMessage(e.getMessage());
		failureResponse.setUserMessage("System Error");
		copyRequestCommonData(request, failureResponse);
		return failureResponse;
	}

}
