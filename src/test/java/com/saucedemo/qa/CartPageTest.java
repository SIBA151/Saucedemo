package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.BaseTest;
import com.saucedemo.qa.pageObjects.CartPage;
import com.saucedemo.qa.pageObjects.HomePage;
import com.saucedemo.qa.pageObjects.LoginPage;



public class CartPageTest extends BaseTest{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	@BeforeMethod
	public void setup() {
		browserSetup();
		loginPage=new LoginPage();
		homePage=new HomePage();
		cartPage=new CartPage();
		loginPage.doValidLogin("standard_user", "secret_sauce");
		homePage.validateAddCartLink();	
	}
	
	@Test(priority=1)
	public void cartPageTitleTest() {
		logger.info("**********TestCase verify Cart Page Title Test Stats**********"); 	

		Assert.assertEquals(cartPage.validateCartPageTitle(), "Swag Labs");
		
		logger.info("**********TestCase verify Cart Page Title Test Ends**********");
	}
	@Test(priority=2)
	public void cartPageLogoTest() {
		logger.info("**********TestCase verify Cart Page Logo Test Starts**********"); 	

		Assert.assertTrue(cartPage.validateCartPageLogo());
		logger.info("**********TestCase verify Cart Page Logo Test Ends**********"); 
	}
	@Test(priority=3)
	public void cartPageLabelTest() {
		logger.info("**********TestCase verify Cart Page Label Test Starts**********"); 	

		Assert.assertTrue(cartPage.validateCartLabel());
		
		logger.info("**********TestCase verify Cart Page Label Test Ends**********");
	}
	@Test(priority=4)
	public void removeproductBtnTest() {
		
		logger.info("**********TestCase verify Remove Product Btn Test Starts**********"); 	

		cartPage.validatecContinueShoppingBtn();
		homePage.addExpensiveProduct();
		homePage.validateAddCartLink();
		cartPage.validateRmoveBtn();
		
		logger.info("**********TestCase verify Remove Product Btn Test Ends**********"); 
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
