package com.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String folderName, String screenshotName) {
        try {
            // Get the project's root directory
            String projectPath = System.getProperty("user.dir");

            // Format the current date as "dd MMM yyyy"
            String currentDate = new SimpleDateFormat("dd MMM yyyy").format(new Date());

            // Replace spaces with underscores to create a valid folder name
            String formattedFolderName = currentDate.replace(" ", "_");

            // Specify the base path for screenshots using the project's root directory
            String basePath = projectPath + "/screenshots/";

            // Combine the base path, formatted folder name, and the provided folder name
            String fullFolderPath = basePath + formattedFolderName + "/" + folderName;

            // Create the folder if it doesn't exist
            File folder = new File(fullFolderPath);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.out.println("Folder created: " + fullFolderPath);
                } else {
                    System.err.println("Failed to create folder: " + fullFolderPath);
                    return;  // Exit the method if folder creation fails
                }
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Specify the destination path for the screenshot
            String destination = fullFolderPath + "/" + screenshotName + ".png";
            org.apache.commons.io.FileUtils.copyFile(source, new File(destination));

            System.out.println("Screenshot taken: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
