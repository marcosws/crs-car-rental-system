package com.github.marcosws.crs.model.service;

import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.utils.Cryptography;
import com.github.marcosws.crs.model.service.utils.LoginStatus;

public class CRSLoginService {
	
	public LoginStatus validateUser(UserEntity user, String password) {
		
		if(user == null || password == null || password.isEmpty())
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		if(user.getUserPassword().equals(Cryptography.hashSHA512(password))){
			
			if(!user.isUserActive())
				return LoginStatus.INACTIVE;
			
			if(user.isUserResetPassword())
				return LoginStatus.RESET_PASSWORD;
		}
		else
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		return LoginStatus.USER_OK;
		
	}
	public LoginStatus validateLogin(String login, String password) {
		
		if(login == null || login.isEmpty())
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		if(password == null || password.isEmpty())
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		return LoginStatus.USER_OK;
		
	}

}
