package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {

	WebDriver ldriver;
	public OrderSuccessPage(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath = "//span[contains(text(),'Thank you for your purchase!')]")
	WebElement successmsg;

	public String successMessage() {
		String text= successmsg.getText();
		System.out.println(text);
		return text;
	}

}
