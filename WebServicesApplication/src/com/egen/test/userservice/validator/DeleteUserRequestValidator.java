package com.egen.test.userservice.validator;

import org.springframework.stereotype.Component;

import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.requestValidator.IRequestValidator;

@Component("deleteUserRequestValidator")
public class DeleteUserRequestValidator implements IRequestValidator {

	@Override
	public boolean validate(IRequest request, EgenException egenException) {
		// TODO Auto-generated method stub
		return true;
	}

}
