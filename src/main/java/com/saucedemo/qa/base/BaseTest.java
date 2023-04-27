package com.saucedemo.qa.base;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.qa.Utility.ConfigRead;

public class BaseTest {
	protected ConfigRead prop;
	
	public static WebDriver driver;
	public static Logger logger=LogManager.getLogger("Saucedemo_Project");
	
	public WebElement getElement(By element) {
		return driver.findElement(element);
	}
	
	
	
	public BaseTest() {
		prop=new ConfigRead();
	}
	
	//Browser setup
	public void browserSetup() {
		String broName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getBrowser();
		
		switch(broName.toLowerCase()){
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default :
		    driver=null;
		    break;
				
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getBaseURL());
		
		logger.info("URL opened");
		
	}
	
	

}
