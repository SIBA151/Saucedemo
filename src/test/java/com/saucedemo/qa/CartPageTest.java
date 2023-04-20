package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.Utility.TestUtility;
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
		Assert.assertEquals(cartPage.validateCartPageTitle(), "Swag Labs");
	}
	@Test(priority=2)
	public void cartPageLogoTest() {
		Assert.assertTrue(cartPage.validateCartPageLogo());
	}
	@Test(priority=3)
	public void cartPageLabelTest() {
		Assert.assertTrue(cartPage.validateCartLabel());
	}
	@Test(priority=4)
	public void removeproductBtnTest() {
		cartPage.validatecContinueShoppingBtn();
		homePage.addExpensiveProduct();
		homePage.validateAddCartLink();
		cartPage.validateRmoveBtn();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
