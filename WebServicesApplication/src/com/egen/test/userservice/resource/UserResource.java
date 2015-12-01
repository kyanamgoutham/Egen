/**
 * 
 */
package com.egen.test.userservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.test.framework.resource.Resource;
import com.egen.test.framework.response.IResponse;
import com.egen.test.userservice.facade.CreateUserResourceFacade;
import com.egen.test.userservice.facade.DeleteUserResourceFacade;
import com.egen.test.userservice.facade.FindUserResourceFacade;
import com.egen.test.userservice.facade.ListUserResourceFacade;
import com.egen.test.userservice.request.CreateUserRequest;
import com.egen.test.userservice.request.DeleteUserRequest;
import com.egen.test.userservice.request.FindUserRequest;
import com.egen.test.userservice.request.ListUserRequest;

/**
 * @author Goutham
 *
 */
@Component
@Path("/userservice")
public class UserResource extends Resource {
	@Autowired
	private ListUserResourceFacade listUserResourceFacade;
	@Autowired
	private CreateUserResourceFacade createUserResourceFacade;
	@Autowired
	private FindUserResourceFacade findUserResourceFacade;
	
	@Autowired
	private DeleteUserResourceFacade deleteUserResourceFacade;
	
	@POST
	@Path("/listuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IResponse getUserList(ListUserRequest request) {
		IResponse response = null;
		response = listUserResourceFacade.initiate().initiateService(request, response);
		copyRequestCommonData(request, response);
		return response;
	}

	@POST
	@Path("/finduser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IResponse findUser(FindUserRequest request) {
		IResponse response = null;
		response = findUserResourceFacade.initiate().initiateService(request, response);
		copyRequestCommonData(request, response);
		return response;
	}

	@POST
	@Path("/createuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IResponse createUser(CreateUserRequest request) {
		IResponse response = null;
		response = createUserResourceFacade.initiate().initiateService(request, response);
		copyRequestCommonData(request, response);
		return response;
	}
	
	@POST
	@Path("/deleteuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IResponse deleteUser(DeleteUserRequest request) {
		IResponse response = null;
		response = deleteUserResourceFacade.initiate().initiateService(request, response);
		copyRequestCommonData(request, response);
		return response;
	}
}
