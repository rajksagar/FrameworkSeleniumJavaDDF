package com.mystroe.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.BuyProductPage;
import com.mystore.pageobject.CheckOutPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.OrderSuccessPage;
import com.mystore.pageobject.SearchResultPage;

public class TC_BuyProductPageTest extends BaseClass{
	@Test//(dataProvider = "LoginDataProvider",dataProviderClass = TC1_MyAccountCreationDataDrivenTest.class)
	//public void VerifyBuyProduct(String email,String password, String title) throws Exception {
	public void VerifyBuyProduct() throws Exception {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String searchKey="Fitness Tee";
		logger.info("****************** Buy Product Test Case Started ******************* ");
		HomePage Hpg= new HomePage(driver); 
		Hpg.clickOnSignIn(); // click on sign in link
		logger.info("Clicked on Sign IN");
		// Enter Values in email and password
		Hpg.EnterRegEmail("Satish1131@gmail.com");
		logger.info("Entered email address");
		Hpg.EnterRegPassword("Satish@123");
		logger.info("Entered password");
//		Hpg.EnterRegEmail(email);
//		logger.info("Entered Email ");
//		Hpg.EnterRegPassword(password);
//		logger.info("Entered Password");
		Hpg.clickOnRegSignIN();
		logger.info("Clicked on RegSign IN");

		// Enter searchKey in search box
		Hpg.searchProduct(searchKey);
		logger.info("Product name entered");
		Hpg.ClickOnSearchBtn();

		// To click on product name
		SearchResultPage resultpage= new SearchResultPage(driver);
		resultpage.clickOnProductName();

		//To Select Size, Color and QUanity of Product

		BuyProductPage productpage= new BuyProductPage(driver);
		productpage.sizeOfProduct();
		productpage.colorOfProduct();
		productpage.quantityOfProduct(2);
		productpage.clickOnAddtoCartButton();
		logger.info("Product added to cart");
		
		Thread.sleep(5000);
	
		productpage.clickOnAddtoCartIcon();
		logger.info("clicked on add to cart icon");
		productpage.clickOnCheckout();
		logger.info("clicked on checkout");
		// To place an order 
		CheckOutPage checkout= new CheckOutPage(driver);
		waitForPageToLoad(Duration.ofSeconds(20));
		checkout.clickOnPriceBtn();
		logger.info("clicked on price button");
		waitForPageToLoad(Duration.ofSeconds(10));
		checkout.clickOnNextBtn();
		logger.info("clicked on next button");
	
		waitForPageToLoad(Duration.ofSeconds(10));
		checkout.clickOnPlaceOrder();
		logger.info("clicked on place order");
		
		//waitForPageToLoad(Duration.ofSeconds(10));
		// Get message of ordered placed
		OrderSuccessPage successpage= new OrderSuccessPage(driver);
		String successmsg=successpage.successMessage();
		System.out.println("Text from page:"+successmsg);
		String ExpMsg="Thank you for your purchase!";
		// Verify that correct product is displayed after search
		if(successmsg.equalsIgnoreCase(ExpMsg)) {

			LogoutPage logout= new LogoutPage(driver);
			logout.Logout();
			logger.info("Clicked Logout");
			Assert.assertTrue(true);
			logger.info("Buy product testcase passed");
		}
		else {
			logger.info("Buy product testcase failed");
			captureScreenShot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);
		}
		logger.info("****************** Buy Product Test Case end ******************* ");

	}
}
