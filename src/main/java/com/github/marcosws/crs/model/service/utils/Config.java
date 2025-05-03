package com.github.marcosws.crs.model.service.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private String databaseName;
	
	public String getDatabaseName() {
		return databaseName;
	}

	public Config() {
		Properties properties = loadProperties("config/config.properties");
		this.databaseName = properties.getProperty("database.name");
    }
	
	public Config(String filePath) {
        Properties properties = loadProperties(filePath);
        this.databaseName = properties.getProperty("database.name");
    }
	
	private Properties loadProperties(String filePath) {
		
		Properties properties = new Properties();
		try (FileInputStream input = new FileInputStream(filePath)) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
