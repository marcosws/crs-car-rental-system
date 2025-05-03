package com.github.marcosws.crs.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteConfig;

import com.github.marcosws.crs.model.service.utils.Config;

public class SQLConnection {
	
	/**
	 * This method is responsible for establishing a connection with the SQLite database.
	 * @author Marcos Willian de Souza
	 * @return Connection object
	 */
	public static Connection getConnection() {
		
		String databaseName = new Config().getDatabaseName();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        String path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:".concat(path).concat("/database/".concat(databaseName));
        
        try {
			return DriverManager.getConnection(url, config.toProperties());
		} 
        catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
		
	}

}
