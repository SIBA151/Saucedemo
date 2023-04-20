package com.saucedemo.qa.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

	public Properties prop;
	
	public ConfigRead() {
		String filePath=System.getProperty("user.dir")+"\\config\\config.properties";
		try {
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//get url method
	public String getBaseURL() {
		String value= prop.getProperty("appURL");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("URL is not available in config file");
		}
	}
	
	public String getBrowser() {
		String value=prop.getProperty("browser");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Browser is not available in config file");
		}
	}
	
}
