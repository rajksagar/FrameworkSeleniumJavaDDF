package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerClass  implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		ReadConfig readconfig= new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy-MM-dd ' ' HH.mm.ss").format(new Date());
		String reportname="MyStoreReport "+timestamp+" .html";
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportname);
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add the system information / configuration
		reports.setSystemInfo("Machine:", "HP130");
		reports.setSystemInfo("OS:", "Windows 10");
		reports.setSystemInfo("Browser:", readconfig.getBrowser());
		reports.setSystemInfo("Username:", "Omkar");
		reports.setSystemInfo("Profile:", "QA");

		//Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Report Using TestNg");
		htmlReporter.config().setReportName("First Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		System.out.println("Configuration done");
	}
	
	// This method execute when first test starts
	public void onStart(ITestContext result) {
		configureReport();
		System.out.println("On start method invoked...");
	}
	// This method execute when all tests are executed
	public void onFinish(ITestContext result) {
		System.out.println("On finsihed method invoked...");
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.
	}

	// When test case get failed this method executed
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed: "+result.getName());
		test=reports.createTest(result.getName()); // This will create entry in html report
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of failed test case: "+result.getName(), ExtentColor.RED));
		test.fail(result.getThrowable());
		// To add the ScreenShot in your Extent report
		String screenshotpath=System.getProperty("user.dir")+"\\ScreenShot\\"+result.getName()+".png";
		File screenshotfile=new File(screenshotpath);
		
		if(screenshotfile.exists()) {
			test.fail("Captured ScreenShot is:"+test.addScreenCaptureFromPath(screenshotpath));
		}
	}

	// when test case get skipped this method will executed
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped: "+result.getName());
		test=reports.createTest(result.getName()); // This will create entry in html report
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of Skip test case: "+result.getName(), ExtentColor.YELLOW));
	}
	// When any test case get started this method executed 
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started: "+result.getName());
	}
	// when test case get passed this method executed
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method successfull executed: "+result.getName());
		test=reports.createTest(result.getName()); // This will create entry in html report
		test.log(Status.PASS,MarkupHelper.createLabel("Name of Passed test case: "+result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }
}
