package com.saucedemo.qa.pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.qa.TestComponents.BaseTest;
import com.saucedemo.qa.pageObjects.CartPage;
import com.saucedemo.qa.pageObjects.HomePage;



public class CartPageTest extends BaseTest{
	
	
	HomePage homePage;
	CartPage cartPage;
	
	
	
	@Test(priority=1)
	public void cartPageTitleTest() {
		logger.info("**********TestCase verify Cart Page Title Test Stats**********"); 	
 
		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		cartPage=homePage.validateAddCartLink();
		Assert.assertEquals(cartPage.validateCartPageTitle(), "Swag Labs");
		
		logger.info("**********TestCase verify Cart Page Title Test Ends**********");
	}
	
	
	@Test(priority=2, groups={"smoke"})
	public void cartPageLogoTest() {
		logger.info("**********TestCase verify Cart Page Logo Test Starts**********"); 	

		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		cartPage=homePage.validateAddCartLink();
		Assert.assertTrue(cartPage.validateCartPageLogo());
		logger.info("**********TestCase verify Cart Page Logo Test Ends**********"); 
	}
	
	
	@Test(priority=3)
	public void cartPageLabelTest() {
		logger.info("**********TestCase verify Cart Page Label Test Starts**********"); 	

		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		cartPage=homePage.validateAddCartLink();
		Assert.assertTrue(cartPage.validateCartLabel());
		
		logger.info("**********TestCase verify Cart Page Label Test Ends**********");
	}
	
	
	@Test(priority=4, groups={"smoke"})
	public void removeproductBtnTest() {
		
		logger.info("**********TestCase verify Remove Product Btn Test Starts**********"); 	

		homePage=loginPage.loginApplication("standard_user", "secret_sauce");
		cartPage=homePage.validateAddCartLink();
		cartPage.validatecContinueShoppingBtn();
		homePage.addExpensiveProduct();
		homePage.validateAddCartLink();
		cartPage.validateRmoveBtn();
		
		logger.info("**********TestCase verify Remove Product Btn Test Ends**********"); 
	}
	
	

}
