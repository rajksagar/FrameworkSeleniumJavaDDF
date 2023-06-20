package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver ldriver;
	
	public LogoutPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	// find Logout 
		@FindBy(xpath="//*[@class='action switch']") WebElement ele1; 
		@FindBy(linkText = "Sign Out") WebElement signoutbtn;
		
		public void Logout() {
			
			ele1.click();
			signoutbtn.click();
		}
}
