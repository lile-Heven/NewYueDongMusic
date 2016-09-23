package com.ll.ydmusic.a.login_regist.bmob;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

@SuppressWarnings("serial")
public class MyUserMoreDetails extends BmobObject {
	private String userPassword;
	private String userNickName;
	private String userPhone;
	private String userEmail;
	private String userIdentityCard;
	private String userTrueName;
	private String userHeadImgName;

	public String getUserNickName() {
		return userNickName;
	}


	public MyUserMoreDetails(String userPassword,
			String userNickName, String userPhone, String userEmail,
			String userIdentityCard, String userTrueName ,String userHeadImgName
			) {
		super();
		this.userPassword = userPassword;
		this.userNickName = userNickName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userIdentityCard = userIdentityCard;
		this.userTrueName = userTrueName;
		this.userHeadImgName=userHeadImgName;
		
	}


	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userNickName;
	}

	public void setUserName(String userName) {
		this.userNickName = userName;
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
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserIdentityCard() {
		return userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}


	public String getUserHeadImgName() {
		return userHeadImgName;
	}


	public void setUserHeadImgName(String userHeadImgName) {
		this.userHeadImgName = userHeadImgName;
	}

}
