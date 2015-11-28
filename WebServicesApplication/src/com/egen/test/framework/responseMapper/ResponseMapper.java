package com.egen.test.framework.responseMapper;

import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.response.failure.FailureResponse;

public abstract class ResponseMapper implements IResponseMapper {

	@Override
	public IResponse createInvalidResponse(EgenException egenException) {
		FailureResponse failureResponse = new FailureResponse();
		failureResponse.setCode(egenException.getErrorCode());
		failureResponse.setDeveloperMessage(egenException.getDeveloperMessage());
		failureResponse.setUserMessage(egenException.getUserMessage());
		return failureResponse;
	}
}
