package com.guru99.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
		
	public static String getValue(String filePath, String key) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);
		prop.load(input);
		input.close();
		String value =  prop.getProperty(key);
		return value;
	}
}
