package com.github.marcosws.crs.controller.login;


import com.github.marcosws.crs.model.dao.register.user.UserDAO;
import com.github.marcosws.crs.model.entities.register.user.UserEntity;
import com.github.marcosws.crs.model.service.CRSLoginService;
import com.github.marcosws.crs.model.service.utils.Config;
import com.github.marcosws.crs.model.service.utils.LoginStatus;
import com.github.marcosws.crs.view.mdi.main.CRSLoginView;
import com.github.marcosws.crs.view.utils.CRSLoggedUser;

public class CRSLoginController {
	
	
	private UserEntity user;

	public LoginStatus login(CRSLoginView crsLoginView) {
		
		CRSLoginService crsLoginService = new CRSLoginService();
		String login = crsLoginView.getEditLogin().getText();
		String password = new String(crsLoginView.getPwdPassword().getPassword());
		LoginStatus loginStatus = crsLoginService.validateLogin(login, password);
		if(loginStatus != LoginStatus.USER_OK)
			return loginStatus;	
		
		UserDAO userDAO = new UserDAO();
		user = new UserEntity();
		user = userDAO.read(login);
		loginStatus = crsLoginService.validateUser(user, password);
		if(loginStatus == LoginStatus.USER_OK) {
		
			CRSLoggedUser.setUserName(user.getUserName());
			CRSLoggedUser.setUserLogin(user.getUserLogin());
			CRSLoggedUser.setUserAdministrator(user.isUserAdministrator());
			CRSLoggedUser.setDatabaseName(new Config().getDatabaseName());
			
		}
		return loginStatus;
				
	}
	
}
