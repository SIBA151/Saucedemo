package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.Utility.TestUtility;
import com.saucedemo.qa.base.BaseTest;
import com.saucedemo.qa.pageObjects.HomePage;
import com.saucedemo.qa.pageObjects.LoginPage;

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
		
		logger.info("********** TestCase verify login Page Title starts **********"); 

		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Swag Labs");
		
		logger.info("********** TestCase verify login Page Title Ends **********"); 
	}
	
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		
		logger.info("**********TestCase verify login Page Logo Test Starts**********"); 		
		Assert.assertTrue(loginPage.validateLoginPageLogo());
		logger.info("********** TestCase verify login Page Logo Test Ends **********"); 
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		logger.info("**********TestCase verify valid Login Test Starts**********"); 	
		
		loginPage.doValidLogin("standard_user", "secret_sauce");
		
		logger.info("**********TestCase verify valid Login Test Ends**********");
		
	}
	
	
	@Test(priority=4, dataProvider="getLoginData")
	public void loginWithDifferentCrd(String username, String password) {
		logger.info("**********TestCase verify Login Test with multiple data sets Starts**********"); 	
		
		loginPage.enterUserNameTxtField(username);
		loginPage.enterUserPasswordTxtField(password);
		loginPage.clickLoginBtn();
		logger.info("**********TestCase verify Login Test with multiple data sets Ends**********");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return TestUtility.getTestData("Login");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}

}
