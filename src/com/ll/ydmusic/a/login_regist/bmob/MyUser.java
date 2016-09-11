package com.ll.ydmusic.a.login_regist.bmob;

import cn.bmob.v3.BmobObject;

@SuppressWarnings("serial")
public class MyUser extends BmobObject {
	private String loginAccount;
	private String loginPassword;
	private String userName;
	private String userPhone;
	private String userEmail;
	
	public MyUser(String loginAccount, String loginPassword) {
		super();
		this.loginAccount = loginAccount;
		this.loginPassword = loginPassword;
		
	}
	
	
	
	public MyUser(String loginAccount, String loginPassword, String userName,
			String userPhone, String userEmail) {
		super();
		this.loginAccount = loginAccount;
		this.loginPassword = loginPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	

}
