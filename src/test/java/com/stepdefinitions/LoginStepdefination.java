package StepDefinition;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.EnvConfig;
import utilities.ExcelUtilites;

public class Login {

	WebDriver driver;
	private EnvConfig envConfig = new EnvConfig();
    private String excelFilePath = envConfig.getExcelFilePath();
    String baseUrl = envConfig.getBaseUrl();
	WebDriverWait wait;
	
	@Given("when user navigates to the BookCart application")
	public void when_user_navigates_to_the_book_cart_application1() {
		try {
			// Initialize WebDriver, navigate to the application, and manage timeouts and
			// window size
			driver = new ChromeDriver();
			
			driver.get(baseUrl);
			Options manage = driver.manage();
			manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			manage.window().maximize();
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			
			// Handle the exception here or rethrow it if needed
		}
	}

	@And("User enters the username")
	public void user_enters_the_username() {
		try {
			// Enter username
			LoginPage Lp = new LoginPage(driver);
			String Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 0);
			Lp.UserName(Username);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@And("User enters the password")
	public void user_enters_the_password() 
	{
		try {
			// Enter password
			LoginPage Lp = new LoginPage(driver);
			String Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 1);
			Lp.Password(Password);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@When("user clicks on the login button")
	public void user_clicks_on_login_button() {
		try {
			// Click on the login button to initiate the login process
			//driver.findElement(By.xpath("(//span[text()='Login'])[last()]/..")).click();
			LoginPage Lp = new LoginPage(driver);
			Lp.LoginButton();
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@Then("Login should be successful")
	public void login_button_should_be_success() {
		try {
			// Verify successful login by checking the user button's text
			String text = driver
					.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"))
					.getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@And("user enters the invalid username")
	public void user_enters_the_invalid_username() {
		try {
			// Enter username for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Invalid_Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 2, 0);
			Lp.UserName(Invalid_Username);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@And("user enters the invalid password")
	public void user_enters_the_invalid_password() {
		try {
			// Enter password for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Invalid_Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 2, 1);
			Lp.Password(Invalid_Password);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@Then("Login should be Fail")
	public void login_should_be_fail()

	{
		try {
			// Verify failed login by checking the error message
			String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
			Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}

	}

	@Then("Login should fail")
	public void login_button_should_fail() {
		try {
			// Verify failed login by checking the error message
			String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
			Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@And("user enters an invalid username")
	public void user_enters_an_invalid_username() {
		try {
			// Enter username for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 3, 0);
			Lp.UserName(Username);
		} catch (Exception e) {
			e.printStackTrace();
            System.err.println("An exception occurred: " + e.getMessage());

			// Handle the exception here or rethrow it if needed
		}
	}

	@And("user enters a valid password")
	public void user_enters_a_valid_password() {
		try {
			// Enter password for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Invalid_Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 3, 1);
			Lp.Password(Invalid_Password);
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception here or rethrow it if needed
		}
	}

	@And("user enters a valid username")
	public void user_enters_a_valid_username() {
		try {
			// Enter username for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 4, 0);
			Lp.UserName(Username);
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the exception here or rethrow it if needed
		}
	}

	@And("User enters an invalid password")
	public void user_enters_an_invalid_password() {
		try {
			// Enter password for a different scenario
			LoginPage Lp = new LoginPage(driver);
			String Invalid_Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 4, 1);
			Lp.Password(Invalid_Password);
		} catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("An exception occurred: " + e.getMessage());
			// Handle the exception here or rethrow it if needed
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

			// Handle the exception here or rethrow it if needed
		}
	}
}
