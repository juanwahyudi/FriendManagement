package com.friendmanagement.model;

public class SubscriptionModel {
	private int _OID;
	public int get_OID() {
		return _OID;
	}
	public void set_OID(int _OID) {
		this._OID = _OID;
	}
	private int _UserSourceOID;
	public int get_UserSourceOID() {
		return _UserSourceOID;
	}
	public void set_UserSourceOID(int _UserSourceOID) {
		this._UserSourceOID = _UserSourceOID;
	}
	private int _UserDestinationOID;
	public int get_UserDestinationOID() {
		return _UserDestinationOID;
	}
	public void set_UserDestinationOID(int _UserDestinationOID) {
		this._UserDestinationOID = _UserDestinationOID;
	}
	private UserModel _UserSourceModel;
	public UserModel get_UserSourceModel() {
		return _UserSourceModel;
	}
	public void set_UserSourceModel(UserModel _UserSourceModel) {
		this._UserSourceModel = _UserSourceModel;
	}
	private UserModel _UserDestinationModel;
	public UserModel get_UserDestinationModel() {
		return _UserDestinationModel;
	}
	public void set_UserDestinationModel(UserModel _UserDestinationModel) {
		this._UserDestinationModel = _UserDestinationModel;
	}

}
