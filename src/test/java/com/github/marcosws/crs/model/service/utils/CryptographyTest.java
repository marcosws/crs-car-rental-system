package com.github.marcosws.crs.model.service.utils;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CryptographyTest {
	
	@Test
	void should_hashSHA512() {
		
		String password = "admin";
		String hash = Cryptography.hashSHA512(password);
		
		assertNotNull(hash);
		assertEquals(128, hash.length());
		
	}
	
	@Test
	void should_hashSHA512_String_Null() {
		
		String password = null;
		String hash = Cryptography.hashSHA512(password);
		
		assertNotNull(hash);
		assertEquals("", hash);
		
	}
	
	@Test
	void should_hashSHA512_String_Empty() {
		
		String password = "";
		String hash = Cryptography.hashSHA512(password);
		
		assertNotNull(hash);
		assertEquals("", hash);
		
	}
	

}
