package com.ashik.sqa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenSnap {
    public static void takeScreenshot(WebDriver driver) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot as a file
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Get the current page title (as a representation of page name)
        String currentPageTitle = driver.getTitle().replaceAll("\\W+", ""); // Remove non-alphanumeric characters

        // Generate timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Specify the destination directory
        Path destinationDirectory = Paths.get("src/test/resources/screenshots");

        // Create the directory if it doesn't exist
        if (!Files.exists(destinationDirectory)) {
            try {
                Files.createDirectories(destinationDirectory);
            } catch (IOException e) {
                System.err.println("Failed to create destination directory: " + e.getMessage());
                return;
            }
        }

        // Specify the file path with dynamic file name
        String fileName = String.format("%s_%s.png", currentPageTitle, timestamp);
        Path destinationPath = destinationDirectory.resolve(fileName);

        try {
            // Copy the screenshot file to the specified destination
            Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }


}

