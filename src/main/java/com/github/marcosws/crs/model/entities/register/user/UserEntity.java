package com.github.marcosws.crs.model.entities.register.user;

public class UserEntity {
	
	
	private int userId;
    private String userName;
    private String userLogin;
    private String userPassword;
    private boolean userAdministrator;
    private boolean userActive;
    private boolean userResetPassword;
    private boolean userDelete;
	
	
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
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserAdministrator() {
		return userAdministrator;
	}
	public void setUserAdministrator(boolean userAdministrator) {
		this.userAdministrator = userAdministrator;
	}
	public boolean isUserActive() {
		return userActive;
	}
	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}
	public boolean isUserResetPassword() {
		return userResetPassword;
	}
	public void setUserResetPassword(boolean userResetPassword) {
		this.userResetPassword = userResetPassword;
	}
	public boolean isUserDelete() {
		return userDelete;
	}
	public void setUserDelete(boolean userDelete) {
		this.userDelete = userDelete;
	}

}
