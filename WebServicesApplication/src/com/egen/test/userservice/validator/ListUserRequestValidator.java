package com.egen.test.userservice.validator;

import org.springframework.stereotype.Component;

import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.requestValidator.IRequestValidator;

@Component("listUserRequestValidator")
public class ListUserRequestValidator implements IRequestValidator {

	@Override
	public boolean validate(IRequest request, EgenException egenException) {		
		return true;
	}

}
