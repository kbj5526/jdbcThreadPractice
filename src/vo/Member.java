package vo;

import java.io.Serializable;

public class Member implements Serializable{

	private String userID;
	private String PW;
	private String userName;
	private String Phonenumber;
	public Member(String userID, String pW, String userName, String phonenumber) {
		super();
		this.userID = userID;
		this.PW = pW;
		this.userName = userName;
		this.Phonenumber = phonenumber;
	}
	
	
	public Member(String userID, String pW) {
		super();
		this.userID = userID;
		PW = pW;
	}


	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "Member [userID=" + userID + ", PW=" + PW + ", userName=" + userName + ", Phonenumber=" + Phonenumber
				+ "]";
	}
	
	
	
}
