package com.friendmanagement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	Connection connection;
	CallableStatement callableStatement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public BaseDao() throws Exception {
		connection = Database.InitializeConnection();
	}

	public void CloseConnection() throws Exception {				
		try {
			if (resultSet != null)
				resultSet.close();

			if (callableStatement != null)
				callableStatement.close();

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
