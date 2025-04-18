package com.github.marcosws.crs.controller.crsmain;


import com.github.marcosws.crs.model.dao.register.UserDAO;
import com.github.marcosws.crs.model.entities.register.UserEntity;
import com.github.marcosws.crs.service.Cryptography;
import com.github.marcosws.crs.service.LoginStatus;
import com.github.marcosws.crs.view.mdi.main.CRSLoginView;
import com.github.marcosws.crs.view.utils.CRSLoggedUser;

public class CRSLoginController {
	
	
	private UserEntity user;

	public LoginStatus login(CRSLoginView crsLoginView) {
		
		UserDAO userDAO = new UserDAO();
		user = new UserEntity();
		
		user = userDAO.read(crsLoginView.getEditLogin().getText());
		char[] arrayPassword = crsLoginView.getPwdPassword().getPassword();
		String password = new String(arrayPassword);
		
		if(user == null) {
			return LoginStatus.INVALID_USER_AND_PASSWORD;
		}
		else if(user.getUserPassword().equals(Cryptography.hashSHA512(password))){
				
			if(!user.isUserActive())
				return LoginStatus.INACTIVE;
			
			if(user.isUserResetPassword())
				return LoginStatus.RESET_PASSWORD;
				
			CRSLoggedUser.setUserName(user.getUserName());
			CRSLoggedUser.setUserLogin(user.getUserLogin());
			CRSLoggedUser.setUserAdministrator(user.isUserAdministrator());
				
			return LoginStatus.USER_OK;
			
		}
		return LoginStatus.INVALID_USER_AND_PASSWORD;
	}
	
}
