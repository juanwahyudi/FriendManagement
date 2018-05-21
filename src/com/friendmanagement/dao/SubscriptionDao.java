package com.friendmanagement.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.friendmanagement.model.GeneralResponseModel;


public class SubscriptionDao extends BaseDao {

	public SubscriptionDao() throws Exception {
		super();
	}
	
	public GeneralResponseModel CreateSubscription(String requestor,String target) throws Exception {
		GeneralResponseModel generalResponseModel = new GeneralResponseModel();

		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call CreateSubscription(?,?)}");

			callableStatement.setString("ParamRequestor", requestor);
			callableStatement.setString("ParamTarget", target);

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
	
	public GeneralResponseModel BlockSubcription(String requestor,String target) throws Exception {
		GeneralResponseModel generalResponseModel = new GeneralResponseModel();

		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call BlockSubscription(?,?)}");

			callableStatement.setString("ParamRequestor", requestor);
			callableStatement.setString("ParamTarget", target);

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
	
	public ArrayList<String> GetRecipientList(String email) throws Exception {
		ArrayList<String> friendList = new ArrayList<String>();
		try {
			callableStatement = (CallableStatement) connection.prepareCall("{call GetSubscription(?)}");
			callableStatement.setString("ParamRequestor", email);
			
			resultSet=callableStatement.executeQuery();
			while (resultSet.next()) {
				friendList.add(resultSet.getString("EmailDestination"));				
			}
		} 
		catch (SQLException dataAccessException) {
			// TODO: handle exception
			throw dataAccessException;
		}
		catch (Exception generalException) {
			// TODO: handle exception
			throw generalException;
		}
		finally {
			// TODO: handle finally clause
			this.CloseConnection();
		}
		return friendList;
	}
}
