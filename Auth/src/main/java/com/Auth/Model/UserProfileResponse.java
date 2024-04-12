package com.Auth.Model;

public class UserProfileResponse {

	String userName;
	long moblieNumber;
	String imgUrl;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMoblieNumber() {
		return moblieNumber;
	}
	public void setMoblieNumber(long moblieNumber) {
		this.moblieNumber = moblieNumber;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
