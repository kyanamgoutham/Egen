package com.egen.test.userservice.response;

import java.util.List;

import com.egen.test.framework.response.Response;
import com.egen.test.pojo.User_Table;

public class ListUserResponse extends Response {

	private List<User_Table> userList;
	private int size;

	public List<User_Table> getUserList() {
		return userList;
	}

	public void setUserList(List<User_Table> userList) {
		this.userList = userList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
