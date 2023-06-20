package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties properties; // Java class help to read properties files
	String path="D:\\Automation_Selenium\\Core Java Sessions\\MyStoreV1\\Configuration\\config.properties";

	// Constructor
	public ReadConfig() {

		try {
			properties= new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public String getBaseUrl() {
		String value=properties.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url is not specified in config file");
	}
	public String getBrowser() {
		String value=properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser is not specified in config file");
	}
}
