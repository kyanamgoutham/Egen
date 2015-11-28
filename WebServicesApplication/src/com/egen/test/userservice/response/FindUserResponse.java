package com.egen.test.userservice.response;

import java.util.List;

import com.egen.test.framework.response.Response;
import com.egen.test.pojo.User_Table;

public class FindUserResponse extends Response {
	List<User_Table> userList;
	
	public List<User_Table> getUserList() {
		return userList;
	}

	public void setUserList(List<User_Table> userList) {
		this.userList = userList;
	}
	

}
