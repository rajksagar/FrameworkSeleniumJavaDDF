package com.mystroe.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	String url= readconfig.getBaseUrl();
	String browser= readconfig.getBrowser();
       
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(options);
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;

		default:
			driver=null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Create an object of Logger
		logger=LogManager.getLogger("MyStoreV1");
		logger.info("Url Opening");
		driver.get(url); // Url Opened
		logger.info("Url Opened");		
	}
	public static void waitForPageToLoad(Duration timeOutInSeconds) {
		//System.out.println(timeOutInSeconds);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			error.printStackTrace();
		}
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver, String testname) throws IOException {
		//Convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot= (TakesScreenshot) driver;

		// Call getScreenshotAs method to create image file
		File src=screenshot.getScreenshotAs(OutputType.FILE);

		// Pass the path where you can store your screenshot
		File dest=new File(System.getProperty("user.dir")+"\\ScreenShot\\"+testname+".png");

		// Copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
