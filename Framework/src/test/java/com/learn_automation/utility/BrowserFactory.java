package com.learn_automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static void startApplication(String browserName, String appURL)
	{
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C://Users//Shalini//drivers//chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
		
			driver= new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver= new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		
		driver.get(appURL);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	public static void quitBrowser()
	{
		driver.quit();
	}

}
