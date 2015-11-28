package com.egen.test.framework.response.failure;

import com.egen.test.framework.response.Response;

public class FailureResponse extends Response {
	String developerMessage;
	String userMessage;
	String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
