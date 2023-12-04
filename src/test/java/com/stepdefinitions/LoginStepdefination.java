package com.stepdefinitions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pageobject.LoginPage;
import com.utilities.EnvConfig;
import com.utilities.ExcelUtilites;
import com.utilities.ScreenshotUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefination {

	WebDriver driver;
	private EnvConfig envConfig = new EnvConfig();
	private String excelFilePath = envConfig.getExcelFilePath();
	String baseUrl = envConfig.getBaseUrl();
	WebDriverWait wait;
	
	

	@Given("when user navigates to the BookCart application")
	public void userNavigatesToBookCartApplication() {
	    try {
	        // Initialize WebDriver, navigate to the application, and manage timeouts and window size
	        driver = new ChromeDriver();

	        driver.get(baseUrl);
	        Options manage = driver.manage();
	        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        manage.window().maximize();
	        System.out.println(driver.getTitle());
            ScreenshotUtils.takeScreenshot(driver, "login", "AfterNavigation");

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("An exception occurred: " + e.getMessage());
	    }
	}


	@And("User enters the username")
	public void userEntersTheUsername() {
		try {
			// Enter username
			LoginPage lp = new LoginPage(driver);
			String username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 0);
			lp.UserName(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@And("User enters the password")
	public void userEntersThePassword() {
		try {
			// Enter password
			LoginPage lp = new LoginPage(driver);
			String password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 1);
			lp.Password(password);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@When("user clicks on the login button")
	public void userClicksOnLoginButton() {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.LoginButton();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@Then("Login should be successful")
	public void loginShouldBeSuccessful() {
		try {
			// Verify successful login by checking the user button's text
			String text = driver
					.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"))
					.getText();
			System.out.println(text);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@And("user enters the invalid username")
	public void userEntersTheInvalidUsername() {
		try {
			LoginPage lp = new LoginPage(driver);
			String invalidUsername = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 2, 0);
			lp.UserName(invalidUsername);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@And("user enters the invalid password")
	public void userEntersTheInvalidPassword() {
		try {
			LoginPage lp = new LoginPage(driver);
			String invalidPassword = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 2, 1);
			lp.Password(invalidPassword);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@Then("Login should be Fail")
	public void loginShouldBeFail() {
		try {
			String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
			if (text.trim().equals("Username or Password is incorrect.")) {
				System.out.println("Test case passed. User login failed as expected. Error message: " + text);
			} else {
				System.err.println("Test case failed. Unexpected error message: " + text);
				String otherElementText = driver
						.findElement(
								By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"))
						.getText();
				System.out.println("Text from another element in the else block: " + otherElementText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@Then("Login should fail")
	public void loginShouldFail() {
		try {
			String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
			Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@And("user enters an invalid username")
	public void userEntersAnInvalidUsername() {
		try {
			LoginPage lp = new LoginPage(driver);
			String username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 3, 0);
			lp.UserName(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@And("user enters a valid password")
	public void userEntersAValidPassword() {
		try {
			LoginPage lp = new LoginPage(driver);
			String invalidPassword = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 3, 1);
			lp.Password(invalidPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("user enters a valid username")
	public void userEntersAValidUsername() {
		try {
			LoginPage lp = new LoginPage(driver);
			String username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 4, 0);
			lp.UserName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User enters an invalid password")
	public void userEntersAnInvalidPassword() {
		try {
			LoginPage lp = new LoginPage(driver);
			String invalidPassword = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 4, 1);
			lp.Password(invalidPassword);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
		}
	}

	@Then("login Should fail")
	public void Login_Should_fail() {
		try {
			// Verify failed login by checking the error message
			String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
			Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());

		}

	}
}