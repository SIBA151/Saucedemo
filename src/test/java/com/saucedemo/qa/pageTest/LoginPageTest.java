package com.saucedemo.qa.pageTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.TestComponents.BaseTest;
import com.saucedemo.qa.TestComponents.RetryClass;
import com.saucedemo.qa.Utility.TestUtility;
import com.saucedemo.qa.pageObjects.HomePage;

public class LoginPageTest extends BaseTest{
	HomePage homePage;
	
	
	@Test(priority=1,retryAnalyzer=RetryClass.class)
	public void loginPageTitleTest() {
		
		logger.info("********** TestCase verify login Page Title starts **********"); 

		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Swag Labs");
		
		logger.info("********** TestCase verify login Page Title Ends **********"); 
	}
	
	
	@Test(priority=2, groups={"smoke"})
	public void loginPageLogoTest() {
		
		logger.info("**********TestCase verify login Page Logo Test Starts**********"); 		
		Assert.assertTrue(loginPage.validateLoginPageLogo());
		logger.info("********** TestCase verify login Page Logo Test Ends **********"); 
	}
	
	
	
	@Test(priority=3, dataProvider="getLoginData", retryAnalyzer=RetryClass.class)
	public void loginWithDifferentCrd(String username, String password, String scenario) {
		logger.info("**********TestCase verify Login Test with multiple data sets Starts**********"); 	
		
		homePage=loginPage.loginApplication(username, password);
		
		if(scenario.equals("bothcorrect")) {
			Assert.assertTrue(homePage.productsLabel());
		}else if(scenario.equals("wrongcredentials")){
			Assert.assertTrue(loginPage.validateLoginPageErrMsg());
		}
		logger.info("**********TestCase verify Login Test with multiple data sets Ends**********");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return TestUtility.getTestData("Login");
	}
	
	
	
	

}
