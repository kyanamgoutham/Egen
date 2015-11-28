package com.egen.test.userservice.responsemapper;

import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.responseMapper.ResponseMapper;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.response.CreateUserResponse;

@Component("createUserResponseMapper")
public class CreateUserResponseMapper extends ResponseMapper {

	@Override
	public IResponse buildResponse(IBackendResponse backendResponse) {
		CreateUserResponse createUserResponse = new CreateUserResponse();
		if (backendResponse.isValidResponse()) {

			if (backendResponse.getBackendResponse() instanceof User_Table) {
				createUserResponse.setUser((User_Table) backendResponse.getBackendResponse());
				createUserResponse.setInsertSuccess(true);
			} else {
				createUserResponse.setInsertSuccess(false);
				createUserResponse.setUser(null);
			}
		} else {
			return createInvalidResponse((EgenException)backendResponse.getBackendResponse());
		}
		return createUserResponse;
	}
}
