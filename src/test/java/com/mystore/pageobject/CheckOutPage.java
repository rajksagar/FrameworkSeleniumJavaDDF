package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	// create object of webdriver
	WebDriver ldriver;
	public CheckOutPage(WebDriver rdriver) {
		ldriver= rdriver;	
		PageFactory.initElements(rdriver, this);
	}
	// Identify the elements present in CheckOut Page


	//	@FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
	//	WebElement PriceRadioButton;
	@FindBy(xpath = "//td[contains(text(),'Fixed')]")
	WebElement PriceRadioButton;

	//	@FindBy(name = "ko_unique_1")
	//	WebElement PriceRadioButton;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
	WebElement nextbtn;

	@FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button/span")
	WebElement placeorderbtn;

	//	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div")
	//	WebElement placeorderbtn;

	//	@FindBy(xpath = "//*[@title='Place Order']")
	//	WebElement placeorderbtn;
	//	@FindBy(xpath = "//button[contains(@class,'action primary checkout')]")
	//	WebElement placeorderbtn;


	public void clickOnPriceBtn() {
		PriceRadioButton.click();
	}
	public void clickOnNextBtn() {
		nextbtn.submit();
	}
	public void clickOnPlaceOrder() {

		try {
			Thread.sleep(5000);
			placeorderbtn.click();
			//placeorderbtn.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		WebDriverWait wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
		//		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(placeorderbtn));
		//		ele.sendKeys(Keys.ENTER);
		//placeorderbtn.submit();
		//		boolean display=placeorderbtn.isDisplayed();
		//		if (display){
		//			System.out.println("Button is displayed "+display);
		//			//placeorderbtn.click(); 
		//
		//
		//			WebDriverWait wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
		//			WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button/span")));
		//			ele.click();
		//		}
		//placeorderbtn.submit();
	}
}