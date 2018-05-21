package com.friendmanagement.model;

public class ConnectionModel {

	private int _OID;
	public int get_OID() {
		return _OID;
	}
	public void set_OID(int _OID) {
		this._OID = _OID;
	}
	private int _UserOID1;
	public int get_UserOID1() {
		return _UserOID1;
	}
	public void set_UserOID1(int _UserOID1) {
		this._UserOID1 = _UserOID1;
	}
	private int _UserOID2;
	
	public int get_UserOID2() {
		return _UserOID2;
	}
	public void set_UserOID2(int _UserOID2) {
		this._UserOID2 = _UserOID2;
	}
	private UserModel _UserModel1;
	public UserModel get_UserModel1() {
		return _UserModel1;
	}
	public void set_UserModel1(UserModel _UserModel1) {
		this._UserModel1 = _UserModel1;
	}
	private UserModel _UserModel2;
	public UserModel get_UserModel2() {
		return _UserModel2;
	}
	public void set_UserModel2(UserModel _UserModel2) {
		this._UserModel2 = _UserModel2;
	}
}
