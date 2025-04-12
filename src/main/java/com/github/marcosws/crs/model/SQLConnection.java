package com.github.marcosws.crs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class SQLConnection {
	
	/**
	 * This method is responsible for establishing a connection with the SQLite database.
	 * @author Marcos Willian de Souza
	 * @return Connection object
	 */
	public Connection getConnection() {
		
	
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        String path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + path + "/database/dbcrs.db";
        
        try {
			return DriverManager.getConnection(url, config.toProperties());
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
