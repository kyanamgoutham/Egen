package com.egen.test.userservice.facade;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.BackendResponse;
import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.facade.IResourceFacade;
import com.egen.test.framework.facade.ResourceFacade;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.requestValidator.IRequestValidator;
import com.egen.test.framework.responseMapper.IResponseMapper;
import com.egen.test.framework.service.IService;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.request.CreateUserRequest;
import com.egen.test.userservice.service.IUserService;

@Component("createUserResourceFacade")
public class CreateUserResourceFacade extends ResourceFacade {
	@Autowired
	@Qualifier("createUserRequestValidator")
	IRequestValidator requestValidator;
	@Autowired
	IService service;
	@Autowired
	@Qualifier("createUserResponseMapper")
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
		BackendResponse beResponse = null;
		IUserService userService = (IUserService) service;
		User_Table user = ((CreateUserRequest) request).getUser();
		if (StringUtils.isNotBlank(user.getId())) {
			beResponse = (BackendResponse) userService.findById(user.getId());
			if (beResponse.isValidResponse()) {
				List<User_Table> list = (List<User_Table>) beResponse.getBackendResponse();
				if (list.size() == 1) {
					// update the user table
					User_Table retrievedUser = list.get(0);

					if (user.getAge() > 0) {
						retrievedUser.setAge(user.getAge());
					}
					if (StringUtils.isNotBlank(user.getfName())) {
						retrievedUser.setfName(user.getfName());
					}
					if (StringUtils.isNotBlank(user.getlName())) {
						retrievedUser.setlName(user.getlName());
					}
					if (StringUtils.isNotBlank(user.getmName())) {
						retrievedUser.setmName(user.getmName());
					}
					if (StringUtils.isNotBlank(user.getPhone())) {
						retrievedUser.setPhone(user.getPhone());
					}
					if (StringUtils.isNotBlank(user.getGender())) {
						retrievedUser.setGender(user.getGender());
					}
					if (user.getZip() != 0) {
						retrievedUser.setZip(user.getZip());
					}
					return (BackendResponse) userService.insertByID(retrievedUser);
				}
			} else {
				return beResponse;
			}
		}
		if ("update".equalsIgnoreCase(((CreateUserRequest) request).getOperation())) {
			CreateUserRequest duplicateRequest = new CreateUserRequest();
			duplicateRequest.setOperation("insert");
			duplicateRequest.setUser(((CreateUserRequest) request).getUser());
			EgenException egenException = new EgenException();
			if (!requestValidator.validate(duplicateRequest, egenException)) {
				egenException.setDeveloperMessage(
						"Invalid Request.User ID not found, to save as new user please enter all the required Attributes of the user");
				beResponse = new BackendResponse();
				beResponse.setBackendResponse(egenException);
				return beResponse;
			}
		}
		return (BackendResponse) userService.save(user);
	}
}
