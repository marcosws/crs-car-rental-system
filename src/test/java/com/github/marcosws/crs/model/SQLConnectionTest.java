package com.github.marcosws.crs.model;

import org.junit.jupiter.api.Test;

import com.github.marcosws.crs.model.dao.SQLConnection;

import static org.junit.jupiter.api.Assertions.*;

public class SQLConnectionTest {
	
	@Test
	void shouldGetConnection() {

		assertNotNull(SQLConnection.getConnection());
		
	}
	

}
