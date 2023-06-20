package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	// create object of webdriver
	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}

	// Identify the elements present in search page

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a")
	WebElement searchResult;
	
	// To get the text of product name
	public String getSearchResult() {
		return	(searchResult.getText());
	}
	
	// To click on product name
	public void clickOnProductName() {
		searchResult.click();
	}






}
