package com.saucedemo.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement companyLogo;
	
	@FindBy(id="user-name")
	WebElement userName;

	@FindBy(css="#password")
	WebElement userPassword;

	@FindBy(name="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@class='error-button']")
	WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserNameTxtField(String mail) {
		 userName.sendKeys(mail);
	}
	
	public void enterUserPasswordTxtField(String password) {
		userPassword.sendKeys(password);
	}
	
	public void clickLoginBtn(){
		loginBtn.click();
	}
	
	public boolean checkLoginBtnAvailable(){
		return loginBtn.isDisplayed();
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateLoginPageLogo() {
		return companyLogo.isDisplayed();
	}
	
	public boolean validateLoginPageErrMsg() {
		return errorMessage.isDisplayed();
	}
	
	public HomePage loginApplication(String usermail, String userPassword) {
		enterUserNameTxtField(usermail);
		enterUserPasswordTxtField(userPassword);
		clickLoginBtn();
		return new HomePage(driver);
	}

}
