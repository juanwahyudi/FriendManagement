package com.friendmanagement.dao;

public class DatabaseConfigModel {
	private String _databaseConnectionUrl;
	private String _databaseDriverName;
	private String _databaseUser;
	private String _databasePassword;

	public void setDatabaseConnectionUrl(String value) {
		this._databaseConnectionUrl = value;
	}

	public String getDatabaseConnectionUrl() {
		return this._databaseConnectionUrl;
	}

	public void setDatabaseDriverName(String value) {
		this._databaseDriverName = value;
	}

	public String getDatabaseDriverName() {
		return this._databaseDriverName;
	}

	public void setDatabaseUser(String value) {
		this._databaseUser = value;
	}

	public String getDatabaseUser() {
		return this._databaseUser;
	}

	public void setDatabasePassword(String value) {
		this._databasePassword = value;
	}

	public String getDatabasePassword() {
		return this._databasePassword;
	}
}
