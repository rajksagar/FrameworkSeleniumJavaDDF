package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnterNewAddress {

	// create object of webdriver
	WebDriver ldriver;

	public EnterNewAddress(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// Identify elements 
	@FindBy(id = "firstname") WebElement addFirstname;
	@FindBy(id = "lastname") WebElement addLastname;
	@FindBy(id = "telephone") WebElement telephone;
	@FindBy(id = "street_1") WebElement streetAdd;
	@FindBy(id = "city") WebElement addCity; 
	@FindBy(id = "region_id") WebElement state; 
	@FindBy(id = "zip") WebElement postCode; 
	@FindBy(id = "country") WebElement country; 
	//button[@class='action save primary']
	@FindBy(xpath = "//button[@class='action save primary']") WebElement SaveAddress; 

	// Perform Actions
	public void enterAddFirstname(String addFname) {
		addFirstname.clear();
		addFirstname.sendKeys(addFname);
	}
	public void enterAddLastname(String addLname) {
		addLastname.clear();
		addLastname.sendKeys(addLname);
	}
	public void enterTelephone(String number) {
		telephone.sendKeys(number);
	}
	public void enterStreet(String Street) {
		streetAdd.sendKeys(Street);
	}
	public void enterCity(String city) {
		addCity.sendKeys(city);
	}
	public void enterState(String Addstate) {
		Select obj= new Select(state);
		obj.selectByVisibleText(Addstate);
	}
	public void enterPostCode(String pincode) {
		postCode.sendKeys(pincode);
	}
	public void enterCountry(String AddCountry) {
		Select obj= new Select(country);
		obj.selectByVisibleText(AddCountry);
	}
	public void clickOnSaveAddress() {
		SaveAddress.click();
	}	
	
}