package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	

	
	public static Properties prop;
	
	/**
	 * This method is used to load properties from config.Properties 
	 * @return properties
	 */
	public static Properties init_prop(){
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\Config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
