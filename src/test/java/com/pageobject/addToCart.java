package PageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class addToCart

{
	public WebDriver ldriver;
	By Product = By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[2]/app-search/form/input");
	By SearcH_Product = By.cssSelector("span.mat-option-text");
	By Select_Theme = By
			.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/app-theme-picker/button");
	By BookCart = By.xpath("(//button[@color='primary']//span/..)[1]");
	By CarttItemList = By.xpath(("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]"));
	By DeleteItem = By
			.xpath(("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));
	By EmptyCart = By.xpath(("/html/body/app-root/div/app-shoppingcart/div/mat-card/mat-card-title"));

	public addToCart(WebDriver rdriver)

	{
		ldriver = rdriver;

	}

	public void SearchProduct() {

		ldriver.findElement(Product).sendKeys("Roomies");
		ldriver.findElement(SearcH_Product).click();

	}

	public void BookCart() {

		ldriver.findElement(BookCart).click();
	}

	public void SelectTheme() {
		ldriver.findElement(Select_Theme).click();
	}

	public void CartList() {
		ldriver.findElement(CarttItemList).click();
	}
	
	
	
	
	
	

	public void Empty()

	{

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement emptyCartElement = ldriver
				.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/mat-card-title"));

		try {
			// Find the element using the given XPath

			System.out.println(emptyCartElement.getText());

			// Get the text of the element and check for the expected message
			if (emptyCartElement.getText().equals("Shopping cart is empty")) {
				System.out.println("Empty cart message is displayed.");
			} else {
				System.out.println("Cart is not empty or the message is different.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found, cart may not be empty or structure has changed.");
		}

	}
	
	
	
public void getAllButtonsAndStates() 

{

	
	
//	try {
//		Thread.sleep(1000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//	        // Find the delete button element
//	        WebElement deleteButton = ldriver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[6]/button/span[1]/mat-icon"));
//
//	        // Create an instance of Actions
//	        Actions action = new Actions(ldriver);
//
//	        // Perform mouse hover over the delete button
//	        action.moveToElement(deleteButton).perform();
//
//	        
//	        // Get the tooltip text and display it
//	        String tooltipText = deleteButton.getAttribute("title");
//	        System.out.println("Tooltip on hover: " + tooltipText);

	
	

	

	
	
	
	
	
	
	
	
	//        java.util.List<WebElement> buttons = ldriver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr[1]/mat-card-content/td/button/span"));
//
//        // Iterate through each button to determine its state
//        for (WebElement button : buttons) {
//            String buttonId = button.getAttribute("id");
//            if (button.isEnabled()) {
//                System.out.println("Button ID: " + buttonId + " - State: Enabled");
//            } else {
//                System.out.println("Button ID: " + buttonId + " - State: Disabled");
//            }
	
//	List<WebElement> products = ldriver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr"));
//
//    // Create an Actions object
//    Actions action = new Actions(ldriver);
//
//    // Iterate through each row to get the delete button for every product
//    for (WebElement product : products) {
//        // For each row (product), find the delete button within that row
//        WebElement deleteButton = product.findElement(By.xpath(".//td/button[contains(@title, 'Delete Item')"));
//
//        // Perform a mouse hover action on the delete button to display the information
//        action.moveToElement(deleteButton).perform();
//
//        // Wait for a while to see the displayed information (if any)
//        // You may want to introduce a wait to capture the information displayed on hover
//
//        // Capture and display the information of the delete button
//        // For example:
//        String tooltipText = deleteButton.getAttribute("title");
//        System.out.println("Displayed info on hover: " + tooltipText);
//    }

	
	
	// Find all products in the cart
	List<WebElement> products1 = ldriver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr"));

	// Iterate through each product to get the delete button status
	for (int i = 1; i <= products1.size(); i++) {
	    WebElement product = ldriver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr[" + i + "]/mat-card-content/td/button/span"));

	    if (product.isEnabled()) 
	    {
	        System.out.println("Product " + i + ": Delete button is enabled");
	        
	    } 
	    
	    else {
	        System.out.println("Product " + i + ": Delete button is disabled");
	    }
	
	    if (i == products1.size()) 
	    {
	        // Exit the loop when reaching the last product
	        break;
	    }
	
	
	}

        }
	
	
	
	
	

	public void removeItem() throws InterruptedException {

		List<WebElement> CartItems = ldriver.findElements(DeleteItem);

		for (WebElement Element : CartItems) {
			String elementText = Element.getText();
			Thread.sleep(1000); // System.out.println("SearchedProduct:" + elementText);

			if (elementText.equals("Roomies")) {

				ldriver.findElement(By.xpath(
						"/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[6]/button/span[1]/mat-icon"))
						.click();
				System.out.println("Item is removed from the cart");
				Thread.sleep(1000);
				String msg = "Product removed from cart";

				// Check if the page text contains the message and print it
				String pageText = ldriver.findElement(By.tagName("body")).getText();
				if (pageText.contains(msg)) {

					System.out.println(msg + " Successfully");
				}

				else

				{
					System.out.println("Your Item was not deleted from the cart");
				}

				break;

		
			}

		}
	}

}
