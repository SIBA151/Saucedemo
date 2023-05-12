package com.saucedemo.qa.pageTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.TestComponents.BaseTest;
import com.saucedemo.qa.TestComponents.RetryClass;
import com.saucedemo.qa.Utility.TestUtility;

public class LoginPageTest extends BaseTest{
	
	
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
	
	
	
	@Test(priority=3, dataProvider="getLoginData")
	public void loginWithDifferentCrd(String username, String password, String scenario) {
		logger.info("**********TestCase verify Login Test with multiple data sets Starts**********"); 	
		
		homePage=loginPage.loginApplication(username, password);
		
		if(scenario.equals("bothcorrect")) {
			Assert.assertTrue(homePage.validateProductsLabel());
			homePage.validateMenutBtn();
			homePage.validateLogoutBtn();
			
			loginPage.clearCredentialTxt();
			
		}else if(scenario.equals("wrongcredentials")){
			Assert.assertTrue(loginPage.validateLoginPageErrMsg());
			
			loginPage.clearCredentialTxt();
		}
		logger.info("**********TestCase verify Login Test with multiple data sets Ends**********");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return TestUtility.getTestData("Login");
	}
	
	
	
	

}
