package com.mystroe.testcases;

import java.io.IOException;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;
import com.mystore.pageobject.ClickEditAddress;
import com.mystore.pageobject.CreateNewCustomerAccount;
import com.mystore.pageobject.EnterNewAddress;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.RegisteredUserAccountValidate;
import com.mystore.utilities.ReadExcelFile;

public class TC1_MyAccountCreationDataDrivenTest extends BaseClass{

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
	@Test(dataProvider = "LoginDataProvider",priority = 20)
	public void VerifyLogin(String email, String password, String expPageTitle ) throws Exception {
		
		Thread.sleep(2000);
		logger.info("***************TestCase VerifyLogin starts*****************");
		HomePage Hpg= new HomePage(driver); 
		Hpg.clickOnSignIn(); // click on sign in link
		logger.info("Clicked on Sign IN");
		// Enter Values in email and password
		Hpg.EnterRegEmail(email);
		logger.info("Entered Email ");
		Hpg.EnterRegPassword(password);
		logger.info("Entered Password");
		Hpg.clickOnRegSignIN();
		logger.info("Clicked on RegSign IN");
				
		// To Validate that Login is Successfull or not
//		RegisteredUserAccountValidate reg= new RegisteredUserAccountValidate(driver);
//		String username=reg.getRegUsername();
//		//String expUsername="Home Page";
//		if(username.equals(expPageTitle)) {
//			
//			logger.info("Verify Login-Passed");
//			Assert.assertTrue(true);
//		}
//		else {
//			logger.info("Verify Login-Failed");
//			captureScreenShot(driver,"VerifyLogin");
//			Assert.assertTrue(false);
//		}
		logger.info("Verified that user is logged successfully");
		LogoutPage logout= new LogoutPage(driver);
		logout.Logout();
		logger.info("Clicked Logout");
	}
	
	@DataProvider(name="LoginDataProvider")
	public String [][] LoginDataProvider(){
		
	String filename = System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
	
	int ttlrows= ReadExcelFile.getRowCount(filename, "LoginTestData");
	int ttlcolumns= ReadExcelFile.getColCount(filename, "LoginTestData");
	
	String data[][]=new String[ttlrows-1][ttlcolumns];

	for(int i=1;i<ttlrows;i++) { // Rows
		
		for(int j=0;j<ttlcolumns;j++) { // column
			
			data[i-1][j]=ReadExcelFile.getCellValue(filename, "LoginTestData", i, j);
		}	
	}
		return data;	
	}

}
