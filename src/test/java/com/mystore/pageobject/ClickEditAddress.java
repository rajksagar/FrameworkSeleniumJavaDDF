package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickEditAddress {

	// create object of webdriver
	WebDriver ldriver;

	public ClickEditAddress(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// identify elements
	@FindBy(xpath = "//*[@data-ui-id='default-billing-edit-link']") WebElement Edit_Address;

	public void clickOnEditAddress() {
		Edit_Address.click();
	}
}
