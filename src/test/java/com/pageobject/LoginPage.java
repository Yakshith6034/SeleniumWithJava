package PageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver ldriver;

	// Locators for different elements on the login page
	By Username = By.cssSelector("input[formcontrolname='username']");
	By Password = By.cssSelector("input[formcontrolname='password']");
	By Login_Button = By.xpath("(//span[text()='Login'])[2]");

	// Constructor to initialize the WebDriver
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;

	}

	// Method to enter the username
	public void UserName(String uname) {
		ldriver.findElement(Username).sendKeys(uname);
	}

	// Method to enter the password
	public void Password(String pwd) {
		ldriver.findElement(Password).sendKeys(pwd);
	}

	public void LoginButton() {
		ldriver.findElement(Login_Button).click();
	}

}