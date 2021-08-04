package com.companyName.projectName.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.companyName.projectName.Utility.Utility;

public class TestBase {

	protected static Properties prop;
	protected ExtentSparkReporter reporter;
	protected ExtentReports reports;
	protected ExtentTest testLogger;

	public TestBase() {
		String userDir = System.getProperty("user.dir");
		try {
			FileInputStream fis = new FileInputStream(userDir + "/Configuration/config.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Configuration file not loading ----" + e.getMessage());
		}
	}

	@BeforeSuite
	public void setUpSuite() {
		reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Reports/Sample_" + Utility.getCurrentDataTime() + ".html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			String screenshotPath = Utility.captureScreenshotOfFullPage(result.getMethod().getMethodName() + "_"
					+ result.getMethod().getCurrentInvocationCount() + "_Success");
			testLogger.pass("Test passed as we have 0 items in cart",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Utility.captureScreenshotOfFullPage(result.getMethod().getMethodName() + "_"
					+ result.getMethod().getCurrentInvocationCount() + "_Failure");
			testLogger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			String screenshotPath = Utility.captureScreenshotOfFullPage(result.getMethod().getMethodName() + "_"
					+ result.getMethod().getCurrentInvocationCount() + "_Skiped");
			testLogger.skip("Test skip", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		reports.flush();
	}

	/**
	 * This method will initialize the driver with required browser type.
	 */
	public void openTestBrowser() {
		PageBase.initialize(prop);
	}

	/**
	 * This method will quit the browser for test
	 * 
	 */
	public void quitTestBrowser() {
		PageBase.quitBrowser();
	}

}
