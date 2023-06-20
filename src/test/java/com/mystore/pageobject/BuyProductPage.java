package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProductPage {
	// create object of webdriver
	WebDriver ldriver;
	public BuyProductPage(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// Identify the elements present in product page

	@FindBy(xpath = "//*[@id=\"option-label-size-143-item-166\"]")
	WebElement sizeOfProduct;

	@FindBy(xpath = "//*[@id=\"option-label-color-93-item-49\"]")
	WebElement colorOfProduct;

	@FindBy(xpath = "//*[@id='qty']")
	WebElement QuantityOfProduct;

	@FindBy(xpath = "//*[@id=\"product-addtocart-button\"]/span")
	WebElement AddtoCart;
	
//	@FindBy(xpath = "/html/body/div[1]/header/div[2]/div[1]/a")
//	WebElement AddtoCartIcon;
	
	@FindBy(xpath = "//*[@class='minicart-wrapper']")
	WebElement AddtoCartIcon;

	@FindBy(xpath = "//*[@id='top-cart-btn-checkout']")
	WebElement CheckoutButton;

	public void sizeOfProduct() {
		sizeOfProduct.click();
	}

	public void colorOfProduct() {
		colorOfProduct.click();
	}

	public void quantityOfProduct(int quantity) {
		QuantityOfProduct.clear();
		QuantityOfProduct.sendKeys(String.valueOf(quantity)); 
		// String.valueOf(int i)-> Returns the string representation of the int argument. 
	}

	public void clickOnAddtoCartButton() {
		AddtoCart.click();
	}	

	public void clickOnAddtoCartIcon() {
		AddtoCartIcon.click();
	}
	public void clickOnCheckout() {
		CheckoutButton.click();
	}
}
