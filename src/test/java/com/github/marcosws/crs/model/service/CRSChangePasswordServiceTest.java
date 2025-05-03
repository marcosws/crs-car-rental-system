package com.github.marcosws.crs.model.service;

import org.junit.jupiter.api.Test;

import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.utils.Cryptography;
import com.github.marcosws.crs.model.service.utils.LoginStatus;

import static org.junit.jupiter.api.Assertions.*;

public class CRSChangePasswordServiceTest {
	
	@Test
	void should_ValidateChangePassword_UserOk() {
		
		String login = "admin";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.USER_OK, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Invalid_User_and_Password_Empty_Login() {
		
		String login = "";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Null_Login() {
		
		String login = null;
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Empty_ActualPassword() {
		
		String login = "admin";
		char[] actualPassword = "".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Null_ActualPassword() {
		
		String login = "admin";
		char[] actualPassword = null;
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Empty_NewPassword() {
		
		String login = "admin";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "".toCharArray();
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Null_NewPassword() {
		
		String login = "admin";
		char[] actualPassword = "newadmin".toCharArray();
		char[] newPassword = null;
		char[] changePassword = "newadmin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Empty_ChangePassword() {
		
		String login = "admin";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Empty_Password_Null_ChangePassword() {
		
		String login = "admin";
		char[] actualPassword = "newadmin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = null;
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.EMPTY_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_New_Password_Equals_To_Actual() {
		
		String login = "admin";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "admin".toCharArray();
		char[] changePassword = "admin".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.NEW_PASSWORD_EQUALS_TO_ACTUAL, loginStatus);
	}
	
	@Test
	void should_ValidateChangePassword_Different_Password() {
		
		String login = "admin";
		char[] actualPassword = "admin".toCharArray();
		char[] newPassword = "newadmin".toCharArray();
		char[] changePassword = "newadmni".toCharArray();
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, actualPassword, newPassword, changePassword);
		
		assertEquals(LoginStatus.DIFFERENT_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_UserOk() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(true);
		user.setUserResetPassword(false);
		String password = "admin";
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.USER_OK, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Null_User() {
		
		UserEntity user = null;
		String password = "admin";
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Null_Password() {
		
		UserEntity user = new UserEntity();
		String password = null;
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Empty_Password() {
		
		UserEntity user = new UserEntity();
		String password = "";
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_User_Inactive() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(false);
		user.setUserResetPassword(false);
		String password = "admin";
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.INACTIVE, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Password_Invalid() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(true);
		user.setUserResetPassword(true);
		String password = "invalid";
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		LoginStatus loginStatus = crsChangePasswordService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
}
