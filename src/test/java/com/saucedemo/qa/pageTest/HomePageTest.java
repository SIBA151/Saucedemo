package com.saucedemo.qa.pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.qa.TestComponents.BaseTest;
import com.saucedemo.qa.pageObjects.HomePage;





public class HomePageTest extends BaseTest{
	HomePage homePage;
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		logger.info("***************TestCase verify Home Page title Test Starts*****************"); 	
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		Assert.assertEquals(homePage.validateHomePageTitle(), "Swag Labs");
		logger.info("*************** TestCase verify Home Page title Test End *****************"); 	

	}
	
	@Test(priority=2, groups={"smoke"})
	public void HomePageLogoTest() {
		logger.info("***************TestCase verify Home Page Logo Test Starts*****************"); 	
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		Assert.assertTrue(homePage.validateCompanyLogo());
		
		logger.info("***************TestCase verify Home Page Logo Test Ends*****************"); 	

	}
	
	@Test(priority=3)
	public void priorityLabelTest() {
		logger.info("***************TestCase verify priority Label Test Starts*****************"); 	
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		Assert.assertTrue(homePage.productsLabel());
		logger.info("***************TestCase verify priority Label Ends*****************"); 	

	}
	
	@Test(priority=4, groups={"smoke"})
	public void verifyLogoutBtn() {
		logger.info("***************TestCase verify Logout Btn Test Starts*****************"); 	
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		homePage.validateMenutBtn();
		homePage.validateLogoutBtn();
		
		Assert.assertTrue(loginPage.checkLoginBtnAvailable());
		logger.info("***************TestCase verify Logout Btn Test Ends*****************"); 	

	}
	
	@Test(priority=5, groups={"smoke"})
	public void selectExpensiveProduct() {
		logger.info("***************TestCase verify select Expensive Product Test Starts*****************"); 	
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		homePage.addExpensiveProduct();
		Assert.assertEquals(homePage.getNumaddCartLink(), "1");	
		logger.info("***************TestCase verify select Expensive Product Test Ends*****************"); 	
        
	}
	
	

}
