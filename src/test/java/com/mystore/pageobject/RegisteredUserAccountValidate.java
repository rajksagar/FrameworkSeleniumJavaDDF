package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccountValidate {

	WebDriver ldriver;

	public RegisteredUserAccountValidate(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String getPageTitle() {
		String text=ldriver.getTitle();
		return text;
	}
	
//	@FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[1]/span")
//	WebElement Regusername;
	
	
	public String getRegUsername() {
		String username= ldriver.getTitle();
		return username;
	}
}
