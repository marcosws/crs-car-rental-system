package com.github.marcosws.crs.model.dao.register.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.github.marcosws.crs.model.dao.ICrudDAO;
import com.github.marcosws.crs.model.dao.SQLConnection;
import com.github.marcosws.crs.model.entities.register.user.UserEntity;

public class UserDAO implements ICrudDAO<UserEntity> {
	
	
	private Connection connection;
	

	@Override
	public void create(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	public UserEntity read(String userLogin) {
		
		this.connection = SQLConnection.getConnection();
		UserEntity user = new UserEntity();
		
		try {
			
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_USER WHERE USER_LOGIN = ?");
			preparedStatement.setString(1, userLogin);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			if(!resultSet.isClosed()) {
				
				user.setUserId(resultSet.getInt("USER_ID"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setUserLogin(resultSet.getString("USER_LOGIN"));
				user.setUserPassword(resultSet.getString("USER_PASSWORD"));
				user.setUserAdministrator(resultSet.getBoolean("USER_ADMINISTRATOR"));
				user.setUserActive(resultSet.getBoolean("USER_ACTIVE"));
				user.setUserResetPassword(resultSet.getBoolean("USER_RESET_PASSWORD"));
				user.setUserDelete(resultSet.getBoolean("USER_DELETE"));
				
				resultSet.close();
				
				this.connection.close();
				return user;
			}
			else {
				this.connection.close();
				return null;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	

	@Override
	public UserEntity read(Long id) {
		
		this.connection = SQLConnection.getConnection();
		UserEntity user = new UserEntity();
		
		try {
			
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_USER WHERE USER_ID = ?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			if(!resultSet.isClosed()) {
				
				user.setUserId(resultSet.getInt("USER_ID"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setUserLogin(resultSet.getString("USER_LOGIN"));
				user.setUserPassword(resultSet.getString("USER_PASSWORD"));
				user.setUserAdministrator(resultSet.getBoolean("USER_ADMINISTRATOR"));
				user.setUserActive(resultSet.getBoolean("USER_ACTIVE"));
				user.setUserResetPassword(resultSet.getBoolean("USER_RESET_PASSWORD"));
				user.setUserDelete(resultSet.getBoolean("USER_DELETE"));
				
				resultSet.close();
				
				this.connection.close();
				return user;
			}
			else {
				this.connection.close();
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserEntity> readAll() {
		
		this.connection = SQLConnection.getConnection();
		try {
			
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM TB_USER");
			ResultSet resultSet = preparedStatement.executeQuery();
			List<UserEntity> userList = new ArrayList<UserEntity>();
			UserEntity user = new UserEntity();
			
			if(!resultSet.isClosed()) {
				while(resultSet.next()) {
					
					user.setUserId(resultSet.getInt("USER_ID"));
					user.setUserName(resultSet.getString("USER_NAME"));
					user.setUserLogin(resultSet.getString("USER_LOGIN"));
					user.setUserPassword(resultSet.getString("USER_PASSWORD"));
					user.setUserAdministrator(resultSet.getBoolean("USER_ADMINISTRATOR"));
					user.setUserActive(resultSet.getBoolean("USER_ACTIVE"));
					user.setUserResetPassword(resultSet.getBoolean("USER_RESET_PASSWORD"));
					user.setUserDelete(resultSet.getBoolean("USER_DELETE"));
					
					userList.add(user);
				}
				resultSet.close();
				
				this.connection.close();
				return userList;
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}



}
