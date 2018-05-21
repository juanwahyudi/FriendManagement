package com.friendmanagement.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.friendmanagement.model.GeneralResponseModel;

public class UserDao extends BaseDao {

	public UserDao() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	public GeneralResponseModel CreateFriendConnection(String email1, String email2) throws Exception {
		GeneralResponseModel generalResponseModel = new GeneralResponseModel();

		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call CreateConnection(?,?)}");

			callableStatement.setString("ParamEmail1", email1);
			callableStatement.setString("ParamEmail2", email2);

			callableStatement.execute();
			generalResponseModel.setSuccess(true);

			callableStatement = (CallableStatement) connection.prepareCall("{call CreateConnection(?,?)}");
			callableStatement.setString("ParamEmail1", email2);
			callableStatement.setString("ParamEmail2", email1);
			callableStatement.execute();
			generalResponseModel.setSuccess(true);

		} catch (SQLException sqlException) {
			// TODO: handle exception
			generalResponseModel.setSuccess(false);
			generalResponseModel.setErrorMessage(sqlException.getMessage());
		} catch (Exception generalException) {
			// TODO: handle exception
			generalResponseModel.setSuccess(false);
			generalResponseModel.setErrorMessage(generalException.getMessage());
		} finally {
			this.CloseConnection();
		}

		return generalResponseModel;
	}

	public ArrayList<String> GetFriendList(String email) throws Exception {
		ArrayList<String> friendList = new ArrayList<String>();
		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call GetConnection(?)}");
			callableStatement.setString("ParamEmail", email);

			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				friendList.add(resultSet.getString("Email2"));
			}
		} catch (SQLException dataAccessException) {
			// TODO: handle exception
			throw dataAccessException;
		} catch (Exception generalException) {
			// TODO: handle exception
			throw generalException;
		} finally {
			// TODO: handle finally clause
			this.CloseConnection();
		}
		return friendList;
	}

	public ArrayList<String> GetMutualFriendList(String email1, String email2) throws Exception {
		ArrayList<String> friendList = new ArrayList<String>();
		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call GetConnection(?)}");
			callableStatement.setString("ParamEmail", email1);

			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				friendList.add(resultSet.getString("Email2"));
			}

			ArrayList<String> friendList2 = new ArrayList<String>();
			callableStatement = (CallableStatement) connection.prepareCall("{call GetConnection(?)}");
			callableStatement.setString("ParamEmail", email2);
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				friendList2.add(resultSet.getString("Email2"));
			}
			friendList.retainAll(friendList2);
		} catch (SQLException dataAccessException) {
			// TODO: handle exception
			throw dataAccessException;
		} catch (Exception generalException) {
			// TODO: handle exception
			throw generalException;
		} finally {
			// TODO: handle finally clause
			this.CloseConnection();
		}
		return friendList;
	}
}
