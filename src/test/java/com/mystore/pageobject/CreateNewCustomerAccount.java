package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerAccount {

	// create object of webdriver
	WebDriver ldriver;

	public CreateNewCustomerAccount(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// identify elements
	@FindBy(id = "firstname") WebElement firstname;
	@FindBy(id = "lastname") WebElement lastname;
	@FindBy(id = "email_address") WebElement email_address;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "password-confirmation") WebElement password_confirmation;
	@FindBy(xpath = "//*[@title='Create an Account']") WebElement CreateAccount;

	// Perform operations on identified elements.

	public void enterFirstname(String fname) {
		firstname.sendKeys(fname);
	}
	public void enterLastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void enterEmailAddress(String email) {
		email_address.sendKeys(email);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void ConfirmPassword(String confirm_pwd) {
		password_confirmation.sendKeys(confirm_pwd);
	}
	public void clickOnCreateAccount() {
		CreateAccount.click();
	}		
}
