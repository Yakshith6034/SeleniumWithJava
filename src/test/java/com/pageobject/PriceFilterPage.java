package PageObject;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PriceFilterPage {

	// Locators for Price Filter elements
	By Slider = By.xpath("/html/body/app-root/div/app-home/div/div[1]/div/app-price-filter/div/div[2]/mat-slider");
	By ProductNames = By.xpath(
			"/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content[2]/div/a/strong");
	By ProductPrices = By
			.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content[2]/p");

	// WebDriver instance
	public WebDriver ldriver;

	// Constructor
	public PriceFilterPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	// Method to adjust the price filter and display product information
	public void PriceFilter() {
		// Find the slider element
		WebElement slider = ldriver.findElement(Slider);

		// Create Actions instance for slider interaction
		Actions actions = new Actions(ldriver);

		// Define desired price value and slider properties
		int desiredValue = 50;
		int minSliderValue = 12;
		int maxSliderValue = 1000;
		int sliderWidth = 200;

		// Calculate the desired slider position based on desired value
		int desiredSliderPosition = (desiredValue - minSliderValue) * sliderWidth / (maxSliderValue - minSliderValue);

		// Move the slider to the desired position
		actions.clickAndHold(slider).moveByOffset(desiredSliderPosition, 0).release().perform();

		// Output message indicating selected price range
		System.out.println("Below are the items for the selected price range filter : ");

		// Find and store product names and prices
		List<WebElement> productNames = ldriver.findElements(ProductNames);
		List<WebElement> productPrices = ldriver.findElements(ProductPrices);

		// Loop through product elements and print information
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			String productPriceText = productPrices.get(i).getText();

			// Remove non-numeric characters from the price text and convert to double
			double priceValue = Double.parseDouble(productPriceText.replaceAll("[^0-9.]", ""));
			String formattedOutput = String.format("%d. Product Name: %s%n   - Price: ₹%.2f", (i + 1), productName,
					priceValue);

			// Print the formatted output
			// System.out.println(formattedOutput);

			// Check if the price is below ₹30,000 and print accordingly
			if (priceValue < 30000) {
				// System.out.println((i + 1) + ". Product Name: " + productName + ", Price: ₹"
				// + priceValue);
				System.out.println(formattedOutput);
			} else {
				System.out.println(formattedOutput + " (Price above or equal to ₹30,000)");
			}
		}
	}
}
