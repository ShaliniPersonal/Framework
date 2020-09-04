package com.learn_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginApplication {
	
	WebDriver driver;
	
	public LoginApplication(WebDriver ldriver)
	{
		this.driver= ldriver;
	}
	
	@FindBy(name = "email") WebElement username;
	@FindBy(name= "password") WebElement password;
	@FindBy(xpath= "//div[@class=\"ui fluid large blue submit button\"]") WebElement login;
	
	public void loginCRM(String uname, String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		login.click();
	}

}
