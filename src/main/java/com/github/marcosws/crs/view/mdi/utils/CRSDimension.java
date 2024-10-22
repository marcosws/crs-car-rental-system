package com.github.marcosws.crs.view.mdi.utils;

public class CRSDimension {
	
	private static int width;
	private static int height;
	
	public static int getWidth() {
		return width;
	}
	
	public static void setWidth(int width) {
		CRSDimension.width = Math.abs(width - 2);
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static void setHeight(int height) {
		CRSDimension.height = Math.abs(height - 80);
	}
	
	
	

}
