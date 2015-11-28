package com.egen.test.userservice.responsemapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.exception.EgenException;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.response.failure.FailureResponse;
import com.egen.test.framework.responseMapper.IResponseMapper;
import com.egen.test.framework.responseMapper.ResponseMapper;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.response.ListUserResponse;

@Component("listUserResponseMapper")
public class ListUserResponseMapper extends ResponseMapper {
	@Override
	public IResponse buildResponse(IBackendResponse backendResponse) {
		if (backendResponse.isValidResponse()) {
			ListUserResponse listUserResponse = new ListUserResponse();
			List<User_Table> userList = (List<User_Table>) backendResponse.getBackendResponse();
			listUserResponse.setUserList(userList);
			listUserResponse.setSize(userList.size());
			return listUserResponse;
		} else {
			return createInvalidResponse((EgenException) backendResponse.getBackendResponse());
		}
	}

}
