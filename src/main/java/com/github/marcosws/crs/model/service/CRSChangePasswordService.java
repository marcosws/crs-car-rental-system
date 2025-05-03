package com.github.marcosws.crs.model.service;

import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.utils.Cryptography;
import com.github.marcosws.crs.model.service.utils.LoginStatus;

public class CRSChangePasswordService {
	
	public LoginStatus validateUser(UserEntity user, String password) {
		
		if(user == null || password == null || password.isEmpty())
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		if(user.getUserPassword().equals(Cryptography.hashSHA512(password))){
			
			if(!user.isUserActive())
				return LoginStatus.INACTIVE;
		}
		else
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		
		return LoginStatus.USER_OK;
	}
	
	public LoginStatus validateChangePassword(String login, char[] actualPassword, char[] newPassword, char[] confirmPassword) {
		
		if(login == null || login.isEmpty())
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		if(actualPassword == null || actualPassword.length == 0)
			return LoginStatus.EMPTY_PASSWORD;
		
		if(newPassword == null || newPassword.length == 0)
			return LoginStatus.EMPTY_PASSWORD;
		
		if(confirmPassword == null || confirmPassword.length == 0)
			return LoginStatus.EMPTY_PASSWORD;
		
		if(String.valueOf(actualPassword).equals(String.valueOf(newPassword)))
			return LoginStatus.NEW_PASSWORD_EQUALS_TO_ACTUAL;
		
		if(!String.valueOf(newPassword).equals(String.valueOf(confirmPassword))) 
			return LoginStatus.DIFFERENT_PASSWORD;
		
		return LoginStatus.USER_OK;
	}

}
