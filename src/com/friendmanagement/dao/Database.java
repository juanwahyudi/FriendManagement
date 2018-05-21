package com.friendmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String transactionalDbName = "friend_management";
	
	public static Connection InitializeConnection() throws Exception {
		try {			
			DatabaseFileHelper databaseFileHelper = new DatabaseFileHelper();
			DatabaseConfigModel databaseConfigModel = databaseFileHelper.ReadDatabaseConfigFile(transactionalDbName);
			Connection connection = null;
			Class.forName(databaseConfigModel.getDatabaseDriverName()).newInstance();
			connection = DriverManager.getConnection(databaseConfigModel.getDatabaseConnectionUrl(),
					databaseConfigModel.getDatabaseUser(), databaseConfigModel.getDatabasePassword());
			return connection;
		} catch (SQLException sqlException) {
			throw new Exception(sqlException.getMessage());
		} catch (Exception generalException) {
			throw new Exception(generalException.getMessage());
		}
	}
}
