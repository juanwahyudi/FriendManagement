package com.friendmanagement.model;

import java.util.ArrayList;

public class FriendListModel {
	private boolean success;

	public boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private ArrayList<String> friends;

	public ArrayList<String> getFriends() {
		return this.friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	private int count;

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public FriendListModel(Boolean isSuccess, ArrayList<String> friendList, int totalCount) {
		setSuccess(isSuccess);
		setFriends(friendList);
		setCount(totalCount);
	}
}
