package com.saucedemo.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucedemo.qa.base.BaseTest;


public class LoginPage extends BaseTest{
	private By companyLogo=By.xpath("//div[@class='login_logo']");
	private By userName=By.id("user-name");
	private By userPassword=By.cssSelector("#password");
	private By loginBtn=By.name("login-button");
	
	public WebElement getUserNameTxtField() {
		return getElement(userName);
	}
	
	public WebElement getUserPasswordTxtField() {
		return getElement(userPassword);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateLoginPageLogo() {
		return getElement(companyLogo).isDisplayed();
	}
	
	public HomePage doValidLogin(String usermail, String userPassword) {
		getUserNameTxtField().sendKeys(usermail);
		getUserPasswordTxtField().sendKeys(userPassword);
		getElement(loginBtn).click();
		return new HomePage();
	}

}
