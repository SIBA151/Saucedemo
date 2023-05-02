package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.BaseTest;
import com.saucedemo.qa.pageObjects.HomePage;
import com.saucedemo.qa.pageObjects.LoginPage;





public class HomePageTest extends BaseTest{
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		browserSetup();
		homePage =new HomePage();
		loginPage = new LoginPage();
		loginPage.loginApplication("standard_user", "secret_sauce");
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		logger.info("***************TestCase verify Home Page title Test Starts*****************"); 	

		Assert.assertEquals(homePage.validateHomePageTitle(), "Swag Labs");
		logger.info("*************** TestCase verify Home Page title Test End *****************"); 	

	}
	
	@Test(priority=2)
	public void HomePageLogoTest() {
		logger.info("***************TestCase verify Home Page Logo Test Starts*****************"); 	

		Assert.assertTrue(homePage.validateCompanyLogo());
		
		logger.info("***************TestCase verify Home Page Logo Test Ends*****************"); 	

	}
	
	@Test(priority=3)
	public void priorityLabelTest() {
		logger.info("***************TestCase verify priority Label Test Starts*****************"); 	

		Assert.assertTrue(homePage.productsLabel());
		logger.info("***************TestCase verify priority Label Ends*****************"); 	

	}
	
	@Test(priority=4)
	public void verifyLogoutBtn() {
		logger.info("***************TestCase verify Logout Btn Test Starts*****************"); 	

		homePage.validateMenutBtn();
		homePage.validateLogoutBtn();
		
		Assert.assertTrue(loginPage.checkLoginBtnAvailable());
		logger.info("***************TestCase verify Logout Btn Test Ends*****************"); 	

	}
	
	@Test(priority=5)
	public void selectExpensiveProduct() {
		logger.info("***************TestCase verify select Expensive Product Test Starts*****************"); 	
        
		homePage.addExpensiveProduct();
		Assert.assertEquals(homePage.getNumaddCartLink(), "1");	
		logger.info("***************TestCase verify select Expensive Product Test Ends*****************"); 	
        
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
