package com.egen.test.framework.requestValidator;

import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.request.IRequest;

public interface IRequestValidator {

	boolean validate(IRequest request, EgenException egenException);

}
