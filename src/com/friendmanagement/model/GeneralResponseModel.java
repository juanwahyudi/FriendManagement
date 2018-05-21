package com.friendmanagement.model;

public class GeneralResponseModel {
	private Boolean Success;
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
		Success = success;
	}
	private String ErrorMessage;
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}	
}
