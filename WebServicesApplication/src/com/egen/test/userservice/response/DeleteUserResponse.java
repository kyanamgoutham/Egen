package com.egen.test.userservice.response;

import com.egen.test.framework.response.Response;

public class DeleteUserResponse extends Response {
	boolean deletionSuccessful;

	public boolean isDeletionSuccessful() {
		return deletionSuccessful;
	}

	public void setDeletionSuccessful(boolean deletionSuccessful) {
		this.deletionSuccessful = deletionSuccessful;
	}

}
