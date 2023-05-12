package com.saucedemo.qa.TestComponents;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.qa.Utility.ConfigRead;
import com.saucedemo.qa.pageObjects.HomePage;
import com.saucedemo.qa.pageObjects.LoginPage;

public class BaseTest {
	protected ConfigRead prop;
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public static Logger logger=LogManager.getLogger("Saucedemo_Project");
	
	public WebElement getElement(By element) {
		return driver.findElement(element);
	}
	
	
	
	public BaseTest() {
		prop=new ConfigRead();
	}
	
	//Browser setup
	public WebDriver browserSetup() {
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
		
		logger.info("URL opened");
		return  driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void initialization () {
		browserSetup();
		driver.get(prop.getBaseURL());
		loginPage=new LoginPage(driver);
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
	
		driver.quit();
	}
	
	//Take Screenshot method
		public String takeScreenshot(String screenShotName) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./ScreenShot/"+screenShotName+".png")); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return System.getProperty("user.dir")+"//ScreenShot//"+screenShotName+".png";
		}
	
	

}
