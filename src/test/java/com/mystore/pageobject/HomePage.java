package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// create object of webdriver
	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// Identify web elements
	@FindBy(linkText = "Create an Account")
	WebElement createAccount;

	public void clickCreateAccountLink() {
		createAccount.click();
	}

	// Registered User Login	
	@FindBy(linkText = "Sign In")
	WebElement signin;

	public void clickOnSignIn() {
		signin.click();
	}
	// Enter Registered user email and password for login 
	@FindBy(id = "email")
	WebElement RegEmail;

	@FindBy(id = "pass")
	WebElement RegPassword;

	@FindBy(xpath = "//*[@class='action login primary']")
	WebElement RegSignIn;

	public void EnterRegEmail(String regemail) {
		RegEmail.sendKeys(regemail);
	}

	public void EnterRegPassword(String regpass) {
		RegPassword.sendKeys(regpass);
	}

	public void clickOnRegSignIN() {
		RegSignIn.click();
	}

	// To Search the product
	@FindBy(xpath = "//*[@id='search']")
	WebElement searchProduct;

	@FindBy(xpath = "//*[@id='search_mini_form']/div[2]/button")
	WebElement SearchButton;

	public void searchProduct(String productname) {
		searchProduct.clear();
		searchProduct.sendKeys(productname);
	}
	public void ClickOnSearchBtn() {

		SearchButton.submit();
	}
	
	public String getPageTitle() {
		String pagetitle= ldriver.getTitle();
		return pagetitle;
	}
}
