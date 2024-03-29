package com.saucedemo.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class CartPage {
	
	WebDriver driver;
	
	@FindBy (className="app_logo")
	WebElement cartPageLogo;
	
	@FindBy (xpath="//div[@class='header_secondary_container']")
	WebElement cartLabel;
	
	@FindBy(xpath="//div[@class='item_pricebar']//child:: button[@id='remove-sauce-labs-fleece-jacket']")
	WebElement removeBtn;
	
	@FindBy(name="continue-shopping")
	WebElement continueShoppingBtn;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateCartPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateCartPageLogo() {
		return cartPageLogo.isDisplayed();
	}
	
	public boolean validateCartLabel() {
		return cartLabel.isDisplayed();
	
	}
	public HomePage validatecContinueShoppingBtn() {
		continueShoppingBtn.click();
		return new HomePage(driver);
	}
	
	public void validateRmoveBtn() {
		removeBtn.click();
	}
	

}
