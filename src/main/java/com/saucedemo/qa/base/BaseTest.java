package com.saucedemo.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static Properties prop;
	public static WebDriver driver;
	
	public WebElement getElement(By element) {
		return driver.findElement(element);
	}
	
	public List<WebElement> getElements(By element) {
		return driver.findElements(element);
	}
	
	
	
	public BaseTest() {
		String filePath=System.getProperty("user.dir")+"\\config\\config.properties";
		try {
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void browserSetup() {
		String broName=prop.getProperty("browser");
		if(broName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else if(broName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else if(broName.equalsIgnoreCase("Chrome")){
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("appURL"));
		
	}
	
	

}
