package com.saucedemo.qa.base;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.qa.Utility.ConfigRead;

public class BaseTest {
	ConfigRead prop;
	public static WebDriver driver;
	
	public WebElement getElement(By element) {
		return driver.findElement(element);
	}
	
	public List<WebElement> getElements(By element) {
		return driver.findElements(element);
	}
	
	
	
	public BaseTest() {
		prop=new ConfigRead();
	}
	
	//Browser setup
	public void browserSetup() {
		String broName=prop.getBrowser();
		if(broName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else if(broName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else if(broName.equalsIgnoreCase("Chrome")){
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getBaseURL());
		
	}
	
	

}
