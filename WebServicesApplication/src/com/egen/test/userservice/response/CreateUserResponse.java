package com.egen.test.userservice.response;

import com.egen.test.framework.response.Response;
import com.egen.test.pojo.User_Table;

public class CreateUserResponse extends Response {
	private User_Table user;
	private boolean isInsertSuccess;
	
	public User_Table getUser() {
		return user;
	}
	public void setUser(User_Table user) {
		this.user = user;
	}
	public boolean isInsertSuccess() {
		return isInsertSuccess;
	}
	public void setInsertSuccess(boolean isInsertSuccess) {
		this.isInsertSuccess = isInsertSuccess;
	}
}
