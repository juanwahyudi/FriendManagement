package com.friendmanagement.model;

import java.util.ArrayList;

public class SubscriptionUpdateResultModel {
	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	private ArrayList<String> recipients;

	public ArrayList<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(ArrayList<String> recipients) {
		this.recipients = recipients;
	}

	public SubscriptionUpdateResultModel(Boolean isSuccess, ArrayList<String> recipientList) {
		this.success = isSuccess;
		this.recipients = recipientList;
	}
}
