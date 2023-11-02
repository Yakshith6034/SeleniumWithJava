package PageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.randomStringUtilites;

public class RegistrationPage

{
	public WebDriver ldriver;

	By FirstName = By.xpath("//*[@id=\"mat-input-2\"]");
	By LastName = By.xpath("//*[@id=\"mat-input-3\"]");
	By UserName = By.xpath("//*[@id=\"mat-input-4\"]");
	By Password = By.xpath("//*[@id=\"mat-input-5\"]");
	By ConfirmPassword = By.xpath("//*[@id=\"mat-input-6\"]");

	By Register_button = By.xpath("/html/body/app-root/div/app-login/div/div[1]/div/div/button/span[1]");
	By Gender = By.xpath("//span[@class=\"mat-radio-container\"]");
	By LoginButton = By.xpath("(//span[text()='Login'])[1]/..");

	public RegistrationPage(WebDriver rdriver)

	{
		ldriver = rdriver;

	}

	public void RegisterButton() {

		ldriver.findElement(Register_button).click();

	}

	public void FirstName(String uname) {

		ldriver.findElement(FirstName).sendKeys(uname);

	}

	public void LastName(String uname) {

		ldriver.findElement(LastName).sendKeys(uname);

	}
	
	
	public void Login()
	{

		ldriver.findElement(LoginButton).click();
	}


	public void Password(String Pass)
	{

		ldriver.findElement(Password).sendKeys(Pass);
	}

	public void ConfirmPassword(String ConfirmPass) 
	{

		ldriver.findElement(ConfirmPassword).sendKeys(ConfirmPass);
	}

	public void UserName(String uname) 
	{

		ldriver.findElement(UserName).sendKeys(uname);
	}

	public void Registration() 
	{

		ldriver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[8]")).click();
	}

	public void SubmitWithoutMandatorydeatials() 
	{

		for (int i = 2; i <= 6; i++) 
	    {
	        // Construct the dynamic XPath for each input field and error message
	        String inputXPath = String.format("//input[@id=\"mat-input-%d\"]", i);

	        // Find and click on the input field
	        WebElement inputField = ldriver.findElement(By.xpath(inputXPath));
	        inputField.click();

	        // Find and get the text of the error message
	        
	    }

	}
	
	public void ErrorMessages() 
	{

		String[] expectedErrorMessages = {
	            "First Name is required",
	            "Last Name is required",
	            "User Name is required",
	            "Password is required",
	            
	        };

	        for (int i = 0; i <= 3; i++) {
	            // Construct the dynamic XPath for each error message
	            String errorXPath = String.format("//*[@id='mat-error-%d']", i);

	            // Find and get the text of the error message
	            WebElement errorElement = ldriver.findElement(By.xpath(errorXPath));
	            String actualErrorMessage = errorElement.getText();

	            // Compare actual error message with expected error message
	            if (actualErrorMessage.equals(expectedErrorMessages[i])) {
	                System.out.println("Validation Passed for Field " + i);
	            } else {
	                System.out.println("Validation Failed for Field " + i + ". Expected: " + expectedErrorMessages[i] + ", Actual: " + actualErrorMessage);
	            }
	        }
	}
	
	
	
	
	
	public void Gender() 
	{

		ldriver.findElement(Gender).click();
	}

}
