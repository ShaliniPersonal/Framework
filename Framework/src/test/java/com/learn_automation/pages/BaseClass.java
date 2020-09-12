package com.learn_automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learn_automation.utility.BrowserFactory;
import com.learn_automation.utility.ConfigDataProvider;
import com.learn_automation.utility.ExcelDataProvider;
import com.learn_automation.utility.Helper;

public class BaseClass {

	WebDriver driver;
	public ConfigDataProvider config;
//	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		config= new ConfigDataProvider();
//		excel = new ExcelDataProvider();
		
		ExtentHtmlReporter extenthtml = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/CRMLogin_" + Helper.getCurrentDateandTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extenthtml);
	}
	
	@Parameters({"browser","urlTobeTested"})
	@BeforeClass
	public void setUp(String browser, String url)
	{
		BrowserFactory.startApplication(browser, url);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==(ITestResult.FAILURE))
		{
			
			try {
				logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		report.flush();
	}
}
