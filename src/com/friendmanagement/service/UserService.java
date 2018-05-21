package com.friendmanagement.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.friendmanagement.dao.UserDao;
import com.friendmanagement.model.FriendConnectionPostModel;
import com.friendmanagement.model.FriendListFilterModel;
import com.friendmanagement.model.FriendListModel;
import com.friendmanagement.model.GeneralResponseModel;
import com.google.gson.Gson;

@Path("/User")
public class UserService {

	private UserDao _userDao;

	public UserService() throws Exception {
		// TODO Auto-generated constructor stub
		this._userDao = new UserDao();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/RetrieveFriendsList")
	@Produces(MediaType.APPLICATION_JSON)
	public String RetrieveFriendsList(String input) {
		Gson gson = new Gson();
		String responseString = null;
		FriendListModel friendListModel = null;
		try {
			FriendListFilterModel filterModel = gson.fromJson(input, FriendListFilterModel.class);
			ArrayList<String> friendsList = _userDao.GetFriendList(filterModel.getEmail());
			friendListModel = new FriendListModel(true, friendsList, friendsList.size());
			responseString = gson.toJson(friendListModel);
		} catch (Exception e) {
			// TODO: handle exception
			GeneralResponseModel responseModel = new GeneralResponseModel();
			responseModel.setSuccess(false);
			responseModel.setErrorMessage(e.getMessage());
			responseString = gson.toJson(responseModel);
		}
		return responseString;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/RetrieveMutualFriendsList")
	@Produces(MediaType.APPLICATION_JSON)
	public String RetrieveMutualFriendsList(String input) {
		Gson gson = new Gson();
		String responseString = null;
		FriendListModel friendListModel = null;
		try {
			FriendConnectionPostModel postModel = gson.fromJson(input, FriendConnectionPostModel.class);
			String email1 = postModel.getFriends().get(0);
			String email2 = postModel.getFriends().get(1);
			
			ArrayList<String> mutualFriendList = _userDao.GetMutualFriendList(email1, email2);
			
			friendListModel = new FriendListModel(true, mutualFriendList, mutualFriendList.size());
			responseString = gson.toJson(friendListModel);
		} catch (Exception e) {
			// TODO: handle exception
			GeneralResponseModel responseModel = new GeneralResponseModel();
			responseModel.setSuccess(false);
			responseModel.setErrorMessage(e.getMessage());
			responseString = gson.toJson(responseModel);
		}
		return responseString;
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CreateFriendConnection")
	@Produces(MediaType.APPLICATION_JSON)
	public String CreateFriendConnection(String input) {
		Gson gson = new Gson();
		String responseString = null;
		GeneralResponseModel responseModel = new GeneralResponseModel();

		try {
			FriendConnectionPostModel postModel = gson.fromJson(input, FriendConnectionPostModel.class);

			String email1 = postModel.getFriends().get(0);
			String email2 = postModel.getFriends().get(1);

			responseModel = _userDao.CreateFriendConnection(email1, email2);
		} catch (Exception e) {
			responseModel.setSuccess(false);
			responseModel.setErrorMessage(e.getMessage());
		}
		responseString = gson.toJson(responseModel);
		return responseString;
	}
}
