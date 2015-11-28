package com.egen.test.userservice.request;

import com.egen.test.framework.request.Request;
import com.egen.test.pojo.User_Table;

public class FindUserRequest extends Request {
	User_Table user ;

	public User_Table getUser() {
		return user;
	}

	public void setUser(User_Table user) {
		this.user = user;
	}

}
