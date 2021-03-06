package com.egen.test.userservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.BackendResponse;
import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.facade.IResourceFacade;
import com.egen.test.framework.facade.ResourceFacade;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.requestValidator.IRequestValidator;
import com.egen.test.framework.responseMapper.IResponseMapper;
import com.egen.test.framework.service.IService;
import com.egen.test.userservice.service.IUserService;

@Component("listUserResourceFacade")
public class ListUserResourceFacade extends ResourceFacade {
	@Autowired
	@Qualifier("listUserRequestValidator")
	IRequestValidator requestValidator;
	@Autowired
	IService service;
	@Autowired
	@Qualifier("listUserResponseMapper")
	IResponseMapper responseMapper;

	@Override
	public IResourceFacade initiate() {
		setRequestValidator(requestValidator);
		setService(service);
		setResponseMapper(responseMapper);
		return this;
	}

	@Override
	public IBackendResponse processRequest(IRequest request, IService service) {
		IUserService userService = (IUserService) service;
		return (BackendResponse) userService.getUserList();
	}
}
