package com.github.marcosws.crs.model.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.utils.Cryptography;
import com.github.marcosws.crs.model.service.utils.LoginStatus;

public class CRSLoginServiceTest {
	
	
	@Test
	void should_ValidateLogin_UserOk() {
		
		String login = "admin";
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		
		assertEquals(LoginStatus.USER_OK, loginStatus);
		
	}
	
	@Test
	void should_ValidateLogin_Invalid_User_and_Password_Empty_Login() {
		
		String login = "";
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
		
	}
	
	@Test
	void should_ValidateLogin_Invalid_User_and_Password_Null_Login() {
		
		String login = null;
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
		
	}
	
	@Test
	void should_ValidateLogin_Invalid_User_and_Password_Empty_Password() {
		
		String login = "admin";
		String password = "";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
		
	}
	
	@Test
	void should_ValidateLogin_Invalid_User_and_Password_Null_Password() {
		
		String login = "admin";
		String password = null;
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
		
	}
	
	@Test
	void should_ValidateUser_UserOk() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(true);
		user.setUserResetPassword(false);
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.USER_OK, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Null_User() {
		
		UserEntity user = null;
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Null_Password() {
		
		UserEntity user = new UserEntity();
		String password = null;
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Invalid_User_and_Password_Empty_Password() {
		
		UserEntity user = new UserEntity();
		String password = "";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_User_Inactive() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(false);
		user.setUserResetPassword(false);
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.INACTIVE, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Reset_Password() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(true);
		user.setUserResetPassword(true);
		String password = "admin";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.RESET_PASSWORD, loginStatus);
	}
	
	@Test
	void should_ValidateUser_Password_Invalid() {
		
		UserEntity user = new UserEntity();
		user.setUserPassword(Cryptography.hashSHA512("admin"));
		user.setUserActive(true);
		user.setUserResetPassword(true);
		String password = "invalid";
		
		CRSLoginService crsLoginService = new CRSLoginService();
		LoginStatus loginStatus = crsLoginService.validateUser(user, password);
		
		assertEquals(LoginStatus.INVALID_USER_AND_PASSWORD, loginStatus);
	}
	

}
