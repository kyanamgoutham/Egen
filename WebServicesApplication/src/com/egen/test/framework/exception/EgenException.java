package com.egen.test.framework.exception;

public class EgenException implements IEgenException {
	private Exception exception;
	private String developerMessage;
	private String errorCode;
	private String userMessage;
		
	public void setEgenException(Exception exception,String userMsg,String errorCode){
		setException(exception);
		setErrorCode(errorCode);
		setDeveloperMessage(exception.getMessage());
		setUserMessage(userMsg);
	}
	
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
