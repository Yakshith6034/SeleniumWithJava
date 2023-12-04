package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import PageObject.PriceFilterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.EnvConfig;
import utilities.ExcelUtilites;

public class PriceFilter {
	WebDriver driver;

	private EnvConfig envConfig = new EnvConfig();
	private String excelFilePath = envConfig.getExcelFilePath();
	String baseUrl = envConfig.getBaseUrl();
	WebDriverWait wait;

	@Given("the user opens the BookCart Application")
	public void when_user_navigates_to_the_book_cart_application() {
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
		}
	}

	@Given("User enters username")
	public void user_enters_the_username() {
		try {
			// Enter username
			LoginPage Lp = new LoginPage(driver);
			String Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 0);
			Lp.UserName(Username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("User enters password")
	public void user_enters_the_password() {
		try {
			// Enter password
			LoginPage Lp = new LoginPage(driver);
			String Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 1);
			Lp.Password(Password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		try {

			LoginPage lp = new LoginPage(driver);
			lp.LoginButton();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Then("the user adjusts the price filter settings and display the products")
	public void user_should_be_able_to_adjust_the_pricing() {
		try {
			PriceFilterPage PF = new PriceFilterPage(driver);
			PF.PriceFilter();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
