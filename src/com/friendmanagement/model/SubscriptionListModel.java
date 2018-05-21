package com.friendmanagement.model;

import java.util.ArrayList;

public class SubscriptionListModel {
	  private boolean success;

	  public boolean getSuccess() { return this.success; }

	  public void setSuccess(boolean success) { this.success = success; }

	  private ArrayList<String> recipients;

	  public ArrayList<String> getFriends() { return this.recipients; }

	  public void setFriends(ArrayList<String> friends) { this.recipients = friends; }

}
