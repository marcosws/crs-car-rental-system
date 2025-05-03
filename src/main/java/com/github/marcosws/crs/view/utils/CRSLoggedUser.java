package com.github.marcosws.crs.view.utils;

public class CRSLoggedUser {
	
	
	private static String userName;
	private static String userLogin;
	private static boolean userAdministrator;
	private static String databaseName;
	
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		CRSLoggedUser.userName = userName;
	}
	public static String getUserLogin() {
		return userLogin;
	}
	public static void setUserLogin(String userLogin) {
		CRSLoggedUser.userLogin = userLogin;
	}
	public static boolean isUserAdministrator() {
		return userAdministrator;
	}
	public static void setUserAdministrator(boolean userAdministrator) {
		CRSLoggedUser.userAdministrator = userAdministrator;
	}
	public static String getDatabaseName() {
		return databaseName;
	}
	public static void setDatabaseName(String databaseName) {
		CRSLoggedUser.databaseName = databaseName;
	}
	
}
