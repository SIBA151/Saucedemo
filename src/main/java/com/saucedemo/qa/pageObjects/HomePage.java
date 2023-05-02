package com.saucedemo.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.BaseTest;


public class HomePage extends BaseTest{
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement companyLogo;
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement productsLabel;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> productAmount;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartLink;
	
	
	@FindBy(css="span[class='shopping_cart_badge']")
	WebElement addCartNumLink;
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuBtn;
	
	@FindBy(css="a[id='logout_sidebar_link']")
	WebElement logoutBtn;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCompanyLogo() {
		return companyLogo.isDisplayed();
	}
	
	public WebElement getCartLink() {
		return cartLink;
	}
	
	public String getNumaddCartLink() {
		return addCartNumLink.getText();
	}
	
	public CartPage validateAddCartLink() {
		 cartLink.click();
		 return new CartPage();
	}
	
	public boolean productsLabel() {
		return productsLabel.isDisplayed();
	}
	
	public void validateMenutBtn() {
		menuBtn.click();
	}
	
	public void validateLogoutBtn() {
		logoutBtn.click();
	}
	
	public void addExpensiveProduct() {
		float largAmo=0;
		 for(WebElement elm : productAmount) {
			 float amo=Float.parseFloat(elm.getText().replace("$", ""));
			 if(largAmo<amo) {
				 largAmo=amo;
			 }
		 }
		 
		 String addCartBtnxpath="//div[normalize-space()='$"+largAmo+"']//following-sibling::button[text()='Add to cart']";
		 getElement(By.xpath(addCartBtnxpath)).click();
	}
	
	

}
