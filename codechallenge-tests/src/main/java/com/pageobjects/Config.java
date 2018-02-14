package com.pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private String systemDir = System.getProperty("user.dir");

	private String configPath = systemDir + "\\src\\test\\resources\\config\\config.properties";

	public String readConfig(String propertyKey) throws FileNotFoundException {
		String propertyValue = null;
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(configPath);
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		propertyValue = properties.getProperty(propertyKey);
		return propertyValue;
	}

}
