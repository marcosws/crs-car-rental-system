package com.github.marcosws.crs.controller.crsmain;

import com.github.marcosws.crs.model.dao.register.UserDAO;
import com.github.marcosws.crs.model.entities.register.UserEntity;
import com.github.marcosws.crs.service.Cryptography;
import com.github.marcosws.crs.service.LoginStatus;
import com.github.marcosws.crs.view.mdi.main.CRSChangePasswordView;

public class CRSChangePasswordController {
	
	public LoginStatus changePasword(CRSChangePasswordView crsChangePasswordView) {
		
		UserDAO userDAO = new UserDAO();
		UserEntity user = new UserEntity();
		
		user = userDAO.read(crsChangePasswordView.getEditLogin().getText());
		
		if(user == null)
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		
		if(!user.isUserActive())
			return LoginStatus.INACTIVE;
		
		char[] arrayActualPassword = crsChangePasswordView.getPwdActualPassword().getPassword();
		char[] arrayNewPassword = crsChangePasswordView.getPwdNewPassword().getPassword();
		char[] arrayConfirmPassword = crsChangePasswordView.getPwdConfirmPassword().getPassword();
		
		String actualPassword = new String(arrayActualPassword);
		String newPassword = new String(arrayNewPassword);
		String confirmPassword = new String(arrayConfirmPassword);
		
		if(actualPassword.isEmpty() || newPassword.isEmpty())
			return LoginStatus.EMPTY_PASSWORD;
	
		
		if(!newPassword.equals(confirmPassword))
			return LoginStatus.DIFFERENT_PASSWORD;
	
		
		if(user.getUserPassword().equals(Cryptography.hashSHA512(actualPassword))) {
			user.setUserPassword(Cryptography.hashSHA512(newPassword));
			userDAO.update(user);
			return LoginStatus.USER_OK;
		}
		
		return LoginStatus.INVALID_USER_AND_PASSWORD;
		
	}
	
	

}
