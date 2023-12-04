package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	// Locators for different elements on the login page
	By Username = By.cssSelector("input[formcontrolname='username']");
	By Password = By.cssSelector("input[formcontrolname='password']");
	By Login_Button = By.xpath("(//span[text()='Login'])[2]");

	// Constructor to initialize the WebDriver

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	// Method to enter the username
	public void UserName(String uname) 
	{
		driver.findElement(Username).sendKeys(uname);
	}

	// Method to enter the password

	public void Password(String pwd) {
		driver.findElement(Password).sendKeys(pwd);
	}

	public void LoginButton() {
		driver.findElement(Login_Button).click();
	}

}