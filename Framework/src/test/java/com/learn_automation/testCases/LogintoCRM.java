package com.learn_automation.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learn_automation.pages.BaseClass;
import com.learn_automation.pages.LoginApplication;

public class LogintoCRM extends BaseClass{
	
	WebDriver driver;
	
	@Test
	public void loginAPP()
	{		
		logger= report.createTest("Login to CRM");
		
		LoginApplication loginobj = PageFactory.initElements(driver, LoginApplication.class);
		
		logger.info("Start application");
		
//		loginobj.loginCRM(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		
		loginobj.loginCRM("Selenium_50", "Abcd@123456");
		
		logger.pass("Login Success");
		
	}

}
