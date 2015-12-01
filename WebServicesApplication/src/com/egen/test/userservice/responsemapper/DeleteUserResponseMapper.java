package com.egen.test.userservice.responsemapper;

import org.springframework.stereotype.Component;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.responseMapper.ResponseMapper;
import com.egen.test.userservice.response.DeleteUserResponse;

@Component("deleteUserResponseMapper")
public class DeleteUserResponseMapper extends ResponseMapper {

	@Override
	public IResponse buildResponse(IBackendResponse backendResponse) {
		DeleteUserResponse response = new DeleteUserResponse();
		if("User Deleted".equalsIgnoreCase((String)backendResponse.getBackendResponse())){
			response.setDeletionSuccessful(true);
		}else{
			response.setDeletionSuccessful(false);
		}
		return response;
	}

}
