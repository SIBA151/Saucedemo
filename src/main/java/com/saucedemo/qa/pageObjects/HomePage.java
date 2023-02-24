package com.saucedemo.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saucedemo.qa.base.BaseTest;


public class HomePage extends BaseTest{
	
	private By companyLogo=By.xpath("//div[@class='app_logo']");
	private By productsLabel=By.xpath("//span[text()='Products']");
	private By productAmount=By.xpath("//div[@class='inventory_item_price']");
	private By cartLink=By.cssSelector(".shopping_cart_link");
	private By addCartNumLink=By.cssSelector("span[class='shopping_cart_badge']");
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCompanyLogo() {
		return getElement(companyLogo).isDisplayed();
	}
	
	public WebElement getCartLink() {
		return getElement(cartLink);
	}
	
	public String getNumaddCartLink() {
		return getElement(addCartNumLink).getText();
	}
	
	public CartPage validateAddCartLink() {
		 getElement(cartLink).click();
		 return new CartPage();
	}
	
	public boolean verifyProductsLabel() {
		return getElement(productsLabel).isDisplayed();
	}
	
	public void addExpensiveProduct() {
		float largAmo=0;
		 for(WebElement elm : getElements(productAmount)) {
			 float amo=Float.parseFloat(elm.getText().replace("$", ""));
			 if(largAmo<amo) {
				 largAmo=amo;
			 }
		 }
		 
		 String addCartBtnxpath="//div[normalize-space()='$"+largAmo+"']/following-sibling::button[text()='Add to cart']";
		 getElement(By.xpath(addCartBtnxpath)).click();
	}
	
	

}
