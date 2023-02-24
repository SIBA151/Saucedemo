package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.BaseTest;
import com.saucedemo.qa.pageObjects.HomePage;
import com.saucedemo.qa.pageObjects.LoginPage;

import Utility.TestUtility;

public class LoginPageTest extends BaseTest{
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		browserSetup();
		homePage =new HomePage();
		loginPage=new LoginPage();
			
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Swag Labs");
	}
	@Test(priority=2)
	public void loginPageLogoTest() {
		Assert.assertTrue(loginPage.validateLoginPageLogo());
	}
	@Test(priority=3)
	public void loginTest() {
		loginPage.doValidLogin(prop.getProperty("userMail"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
