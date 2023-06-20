package com.mystroe.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.SearchResultPage;

public class TC_ProductPageTest extends BaseClass {

	@Test//(dataProvider = "LoginDataProvider",dataProviderClass = TC1_MyAccountCreationDataDrivenTest.class)
	//public void VerifySearchProduct(String email,String password, String title) throws IOException {
	public void VerifySearchProduct() throws IOException {
			String searchKey="Fitness Tee";
			logger.info("****************** Search Product Test Case Started ******************* ");
			HomePage Hpg= new HomePage(driver); 
			Hpg.clickOnSignIn(); // click on sign in link
			logger.info("Clicked on Sign IN");
			// Enter Values in email and password
			Hpg.EnterRegEmail("Satish1131@gmail.com");
			logger.info("Entered email address");
			Hpg.EnterRegPassword("Satish@123");
			logger.info("Entered password");
			//	Hpg.EnterRegEmail(email);
			//	logger.info("Entered Email ");
			//	Hpg.EnterRegPassword(password);
			//	logger.info("Entered Password");
			Hpg.clickOnRegSignIN();
			logger.info("Clicked on RegSign IN");

			// Enter searchKey in search box
			Hpg.searchProduct(searchKey);
			logger.info("Product name entered");
			Hpg.ClickOnSearchBtn();

			// Get name of searched product
			SearchResultPage resultpage= new SearchResultPage(driver);
			String productname=resultpage.getSearchResult();

			// Verify that correct product is displayed after search
			if(productname.contains(searchKey)) {
				LogoutPage logout= new LogoutPage(driver);
				logout.Logout();
				logger.info("Clicked Logout");
				Assert.assertTrue(true);
				logger.info("search product testcase passed");
			}
			else {
				logger.info("search product testcase failed");
				captureScreenShot(driver,"VerifySearchProduct");
				Assert.assertTrue(false);
			}

			logger.info("****************** Search Product Test Case end ******************* ");

		}
	}

