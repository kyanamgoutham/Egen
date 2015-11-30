package com.egen.test.userservice.request;

import com.egen.test.framework.request.Request;
import com.egen.test.pojo.User_Table;

public class CreateUserRequest extends Request {
	private User_Table user;
	private String operation;

	public User_Table getUser() {
		return user;
	}

	public void setUser(User_Table user) {
		this.user = user;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
