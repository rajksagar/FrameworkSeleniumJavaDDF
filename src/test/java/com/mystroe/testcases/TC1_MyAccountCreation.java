package com.mystroe.testcases;

import java.io.IOException;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.ClickEditAddress;
import com.mystore.pageobject.CreateNewCustomerAccount;
import com.mystore.pageobject.EnterNewAddress;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.RegisteredUserAccountValidate;

public class TC1_MyAccountCreation extends BaseClass{

	@Test(priority = 10, enabled = false)
	public void VerifyRegistrationAndLogin() {
		//		logger.warn("This is warning");
		//		logger.error("This is error mesg");

		logger.info("***************TestCase Verify Registration and Login starts*****************");
		HomePage Hpg= new HomePage(driver); 
		Hpg.clickCreateAccountLink(); // click create account link
		logger.info("Clicked on Create account link");
		// Enter the values to create account
		CreateNewCustomerAccount createAcc= new CreateNewCustomerAccount(driver);
		createAcc.enterFirstname("Satish");
		createAcc.enterLastname("Shinde");
		createAcc.enterEmailAddress("Satish1131@gmail.com");
		createAcc.enterPassword("Satish@123");
		createAcc.ConfirmPassword("Satish@123");
		createAcc.clickOnCreateAccount();

		logger.info("Name , Email address and password entered");

		ClickEditAddress edit= new ClickEditAddress(driver);
		edit.clickOnEditAddress();
		logger.info("Clicked on edit address");
		EnterNewAddress enternew= new EnterNewAddress(driver);
		enternew.enterAddFirstname("Satish");
		enternew.enterAddLastname("Satish");
		enternew.enterTelephone("9876542343");
		enternew.enterStreet("Pune");
		enternew.enterCity("Pune");
		enternew.enterState("Alabama");
		enternew.enterPostCode("123456");
		enternew.enterCountry("United States");
		enternew.clickOnSaveAddress();
		logger.info("Billing address has been entered");
		// To Validate that acoount is created or not
		RegisteredUserAccountValidate reg= new RegisteredUserAccountValidate(driver);
		String title=reg.getPageTitle();
		//	System.out.println(title);
		//	String expTitle="Address Book Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		//	Assert.assertEquals(expTitle, title);
		logger.info("Verified that user is created");
		LogoutPage logout= new LogoutPage(driver);
		logout.Logout();
		logger.info("Clicked Logout");
	}
	@Test(priority = 20)
	public void VerifyLogin() throws Exception {
		
		Thread.sleep(2000);
		logger.info("***************TestCase VerifyLogin starts*****************");
		HomePage Hpg= new HomePage(driver); 
		Hpg.clickOnSignIn(); // click on sign in link
		logger.info("Clicked on Sign IN");
		// Enter Values in email and password
		Hpg.EnterRegEmail("Satish1131@gmail.com");
		logger.info("Entered Email ");
		Hpg.EnterRegPassword("Satish@123");
		logger.info("Entered Password");
		Hpg.clickOnRegSignIN();
		logger.info("Clicked on RegSign IN");
		
		// To Validate that Login is Successfull or not
		RegisteredUserAccountValidate reg= new RegisteredUserAccountValidate(driver);
		String username=reg.getRegUsername();
		String expUsername="Home Page";
		if(username.equals(expUsername)) {
			
			logger.info("Verify Login-Passed");
			LogoutPage logout= new LogoutPage(driver);
			logout.Logout();
			logger.info("Clicked Logout");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Verify Login-Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		logger.info("************** TestCase VerifyLogin end ***************");
	}
	
	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		HomePage pg = new HomePage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		pg.EnterRegEmail("Satish1131@gmail.com");
		logger.info("Entered email address");

		pg.EnterRegPassword("Satish@123");
		logger.info("Entered password");

		pg.clickOnRegSignIN();
		logger.info("Clicked on Registered sign in link..");

		LogoutPage logout= new LogoutPage(driver);
		logout.Logout();
		logger.info("Clicked Logout");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(pg.getPageTitle().equals("Home Page"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}

}
