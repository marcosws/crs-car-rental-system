package com.github.marcosws.crs.controller.login;

import com.github.marcosws.crs.model.dao.register.user.UserDAO;
import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.CRSChangePasswordService;
import com.github.marcosws.crs.model.service.utils.Cryptography;
import com.github.marcosws.crs.model.service.utils.LoginStatus;
import com.github.marcosws.crs.view.mdi.main.CRSChangePasswordView;

public class CRSChangePasswordController {
	
	public LoginStatus changePasword(CRSChangePasswordView crsChangePasswordView) {
		
		
		CRSChangePasswordService crsChangePasswordService = new CRSChangePasswordService();
		
		String login = crsChangePasswordView.getEditLogin().getText();
		char[] arrayActualPassword = crsChangePasswordView.getPwdActualPassword().getPassword();
		char[] arrayNewPassword = crsChangePasswordView.getPwdNewPassword().getPassword();
		char[] arrayConfirmPassword = crsChangePasswordView.getPwdConfirmPassword().getPassword();
		
		LoginStatus loginStatus = crsChangePasswordService.validateChangePassword(login, arrayActualPassword, arrayNewPassword, arrayConfirmPassword);
		if(loginStatus != LoginStatus.USER_OK)
			return loginStatus;
		
		String actualPassword = new String(arrayActualPassword);
		String newPassword = new String(arrayNewPassword);
		
		UserDAO userDAO = new UserDAO();
		UserEntity user = new UserEntity();
		user = userDAO.read(login);
		
		loginStatus = crsChangePasswordService.validateUser(user, actualPassword);
		if(loginStatus == LoginStatus.USER_OK) {
			user.setUserPassword(Cryptography.hashSHA512(newPassword));
			userDAO.update(user);
			return LoginStatus.USER_OK;
			
		}
		return loginStatus;
		
	}
	
	

}
