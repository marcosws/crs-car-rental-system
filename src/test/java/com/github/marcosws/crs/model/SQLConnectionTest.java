package com.github.marcosws.crs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SQLConnectionTest {
	
	@Test
	void shouldGetConnection() {
		SQLConnection connection = new SQLConnection();
		assertNotNull(connection.getConnection());
	}
	

}
