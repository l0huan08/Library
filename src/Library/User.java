package Library;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String password;
	private String phoneNo;
	private String address;
	private boolean isAdmin;
	private ArrayList<Category> subscribedCategory;
	
	//getters & setters 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public ArrayList<Category> getSubscribedCategory() {
		return subscribedCategory;
	}
	public void setSubscribedCategory(ArrayList<Category> subscribedCategory) {
		this.subscribedCategory = subscribedCategory;
	}
	
}
