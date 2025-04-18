package com.github.marcosws.crs.service;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;


public class Utils {
	
	public static String getFullPathResource(String partialPathOrFile) {
		
		URL resource = null;
		URI uri = null;
		if(System.getProperty("os.name").equalsIgnoreCase("linux")) {
			resource = Utils.class.getResource(partialPathOrFile);
		}
		else {
			String path = FilenameUtils.separatorsToSystem(partialPathOrFile);
			resource = Utils.class.getClassLoader().getResource(path);
		}
		
		try {
			uri = resource.toURI();
		} 
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new File(uri).toString();
	}

}
