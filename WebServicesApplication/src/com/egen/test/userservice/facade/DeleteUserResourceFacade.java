package com.egen.test.userservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.facade.IResourceFacade;
import com.egen.test.framework.facade.ResourceFacade;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.requestValidator.IRequestValidator;
import com.egen.test.framework.responseMapper.IResponseMapper;
import com.egen.test.framework.service.IService;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.request.DeleteUserRequest;
import com.egen.test.userservice.service.IUserService;

@Component("deleteUserResourceFacade")
public class DeleteUserResourceFacade extends ResourceFacade {

	
	@Autowired
	@Qualifier("deleteUserRequestValidator")
	IRequestValidator requestValidator;
	@Autowired
	IService service;
	@Autowired
	@Qualifier("deleteUserResponseMapper")
	IResponseMapper responseMapper;
	@Override
	public IBackendResponse processRequest(IRequest request, IService service) {
		IBackendResponse beResponse = null;
		IUserService userService = (IUserService) service;
		User_Table user = ((DeleteUserRequest)request).getUser();
		beResponse = userService.delete(user);
		return beResponse;
	}

	@Override
	public IResourceFacade initiate() {
		setRequestValidator(requestValidator);
		setService(service);
		setResponseMapper(responseMapper);
		return this;
	}

}
