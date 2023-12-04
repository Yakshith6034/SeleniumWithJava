package utilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if (driver == null) {
            // Initialize WebDriver and common settings
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ykorvi\\Downloads\\SeleniumJavaBDDZIP (2)\\SeleniumJavaBDD\\Drivers\\msedgedriver.exe\\"); // Replace with the actual path to ChromeDriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Maximize the browser window
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
