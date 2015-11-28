package com.egen.test.userservice.responsemapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.responseMapper.ResponseMapper;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.response.FindUserResponse;

@Component("findUserResponseMapper")
public class FindUserResponseMapper extends ResponseMapper {

	@Override
	public IResponse buildResponse(IBackendResponse backendResponse) {
		FindUserResponse findUserResponse = new FindUserResponse();
		if (backendResponse.isValidResponse()) {
			findUserResponse.setUserList((List<User_Table>) backendResponse.getBackendResponse());
		} else {
			return createInvalidResponse((EgenException)backendResponse.getBackendResponse());
		}
		return findUserResponse;
	}

}
