package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
//import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;


public class TestListners implements ITestListener {
	
	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName()
        );

        test.info("Test execution started");

        System.out.println(
                "Test started: " +
                result.getName()
        );
    }
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("test passed successfully");
		System.out.println("Test passed: "  +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		System.out.println("Test failed. Taking screenshot...");
		// Code to take screenshot
		System.out.println("Screenshot taken for test: " + result.getName());
		BaseTest basetest =  (BaseTest) result.getInstance();
		WebDriver driver = basetest.getDriver();
		Screeshot screenshot = new Screeshot();
		screenshot.takeScreenshot(driver,result.getName());
	}
	
	 public void onFinish(ITestContext context) {

	        extent.flush();

	        System.out.println(
	                "Extent Report generated successfully."
	        );
	    }

}
