package com.friendmanagement.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.friendmanagement.dao.SubscriptionDao;
import com.friendmanagement.dao.UserDao;
import com.friendmanagement.model.GeneralResponseModel;
import com.friendmanagement.model.SubscriptionPostModel;
import com.friendmanagement.model.SubscriptionUpdatePostModel;
import com.friendmanagement.model.SubscriptionUpdateResultModel;
import com.google.gson.Gson;

@Path("/Subscription")
public class SubscriptionService {

	SubscriptionDao _sSubscriptionDao;
	UserDao _uUserDao;

	public SubscriptionService() throws Exception {
		this._sSubscriptionDao = new SubscriptionDao();
		this._uUserDao = new UserDao();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/SubscribetoUpdates")
	@Produces(MediaType.APPLICATION_JSON)
	public String SubscribetoUpdates(String input) {
		Gson gson = new Gson();
		String responseString = null;
		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		try {
			SubscriptionPostModel postModel = gson.fromJson(input, SubscriptionPostModel.class);
			_sSubscriptionDao.CreateSubscription(postModel.getRequestor(), postModel.getTarget());
			generalResponseModel.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			generalResponseModel.setSuccess(false);
			generalResponseModel.setErrorMessage(e.getMessage());
		}
		responseString = gson.toJson(generalResponseModel);
		return responseString;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/BlockSubscription")
	@Produces(MediaType.APPLICATION_JSON)
	public String BlockSubscription(String input) {
		Gson gson = new Gson();
		String responseString = null;
		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		try {
			SubscriptionPostModel postModel = gson.fromJson(input, SubscriptionPostModel.class);
			_sSubscriptionDao.BlockSubcription(postModel.getRequestor(), postModel.getTarget());
			generalResponseModel.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			generalResponseModel.setSuccess(false);
			generalResponseModel.setErrorMessage(e.getMessage());
		}
		responseString = gson.toJson(generalResponseModel);
		return responseString;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/RetrieveSubscriptionUpdates")
	@Produces(MediaType.APPLICATION_JSON)
	public String RetrieveSubscriptionUpdates(String input) {
		Gson gson = new Gson();
		String responseString = null;

		try {
			SubscriptionUpdatePostModel postModel = gson.fromJson(input, SubscriptionUpdatePostModel.class);
			ArrayList<String> recipientList = _sSubscriptionDao.GetRecipientList(postModel.getSender());

			ArrayList<String> friendList = _uUserDao.GetFriendList(postModel.getSender());
			recipientList.addAll(friendList);

			java.util.regex.Pattern pattern = java.util.regex.Pattern
					.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

			String[] splitted = postModel.getText().split(" ");
			for (String string : splitted) {
				Matcher mail = pattern.matcher(string);
				if (mail.matches())
					recipientList.add(string);
			}

			recipientList = new ArrayList<String>(new LinkedHashSet<String>(recipientList));
			SubscriptionUpdateResultModel resultModel = new SubscriptionUpdateResultModel(true, recipientList);
			responseString = gson.toJson(resultModel);
		} catch (Exception e) {
			// TODO: handle exception
			GeneralResponseModel responseModel = new GeneralResponseModel();
			responseModel.setSuccess(false);
			responseModel.setErrorMessage(e.getMessage());
			responseString = gson.toJson(responseModel);
		}
		return responseString;
	}

}
