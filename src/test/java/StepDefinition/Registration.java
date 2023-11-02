package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import PageObject.RegistrationPage;
import PageObject.addToCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.EnvConfig;
import utilities.randomStringUtilites;

public class Registration {
    WebDriver driver;

    WebDriverWait wait;
    String name = "";

    private EnvConfig envConfig = new EnvConfig();

    String baseUrl = envConfig.getBaseUrl();

    @Given("the user navigate to the Cart application")
    public void the_user_navigates_to_the_cart_application() {
        try {
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

    @Given("user clicks on  login button")
    public void user_clicks_on_the_login_button() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user clicks on the Register button")
    public void the_user_clicks_on_the_Register_button() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.RegisterButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user enters the First Name")
    public void the_user_enters_the_first_name() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            String FirstName = randomStringUtilites.generateRandomString(10);
            RP.FirstName(FirstName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user enters the Last Name")
    public void the_user_enters_the_last_name() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            String LastName = randomStringUtilites.generateRandomString(10);
            RP.LastName(LastName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user enters the User Name")
    public void the_user_enters_the_user_name() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            name = randomStringUtilites.generateRandomString(10);
            RP.UserName(name);
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user enters the Password")
    public void the_user_enters_the_password() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.Password("WaveRock@2.3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user enters the Confirm Password")
    public void the_user_enters_the_confirm_password() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.ConfirmPassword("WaveRock@2.3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the user select the Gender")
    public void the_user_select_the_Gender() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.Gender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the user details should be saved successfully")
    public void the_user_details_should_be_saved_successfully() {
        try {
            Thread.sleep(3000);
            addToCart AC = new addToCart(driver);
            AC.CartList();
            Thread.sleep(3000);
            String Text = driver.findElement(By.xpath("//span[text()='Register']")).getText();
            System.out.println(Text);
            System.out.println(name);
            driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(name);
            LoginPage Lp = new LoginPage(driver);
            String Pass = "WaveRock@2.3";
            Thread.sleep(2000);
            Lp.Password(Pass);
            System.out.println(Pass);
            Lp.LoginButton();
            System.out.println("Assertion passed: " + Text + "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("they enter a password with only uppercase characters")
    public void they_enter_a_password_with_only_uppercase_characters() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.Password("WaveROCK");
            RP.ConfirmPassword("WaveRock");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Appropriate Error message should be displayed")
    public void error_message_should_be_displayed() {
        try {
            Thread.sleep(2000);
            WebElement Text = driver.findElement(By.xpath("//*[@id=\"mat-error-0\"]"));
            String T = Text.getText();
            System.out.println("ErrorMessage:" + T);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the user submits the form without entering mandatory field")
    public void the_user_submits_the_form_without_entering_the_first_name() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.SubmitWithoutMandatorydeatials();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("user should see the error message for mandatory field")
    public void UserShouldSeeErrorMessage() {
        try {
            RegistrationPage RP = new RegistrationPage(driver);
            RP.ErrorMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
