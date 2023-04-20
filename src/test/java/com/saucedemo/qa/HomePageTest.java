package com.saucedemo.qa;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.Utility.TestUtility;
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
		loginPage.doValidLogin("standard_user", "secret_sauce");
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Swag- Labs");
	}
	
	@Test(priority=2)
	public void HomePageLogoTest() {
		Assert.assertTrue(homePage.validateCompanyLogo());
	}
	
	@Test(priority=3)
	public void priorityLabelTest() {
		Assert.assertTrue(homePage.verifyProductsLabel());
	}
	@Test(priority=4)
	public void selectExpensiveProduct() {
		homePage.addExpensiveProduct();
		Assert.assertEquals(homePage.getNumaddCartLink(), "1");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtility.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
