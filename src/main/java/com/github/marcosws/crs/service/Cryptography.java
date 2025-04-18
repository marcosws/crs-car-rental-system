package com.github.marcosws.crs.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Cryptography {
	
	private static final String SALT = "FEDCBA0123456789";
	
	public static String hashSHA512(String password) {
		
		StringBuilder hexString = new StringBuilder();
		try (Formatter formatter = new Formatter(hexString)) {
			
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(SALT.getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
			for (byte b : bytes) 
				formatter.format("%02x", b);
			
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

}
