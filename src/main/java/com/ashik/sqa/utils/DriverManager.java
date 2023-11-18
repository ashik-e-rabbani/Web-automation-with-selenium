package com.ashik.sqa.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * DriverManager Class
 * --------------------
 *
 * This class implements a simple WebDriver management approach using the Singleton pattern.
 * It provides a centralized mechanism for creating and managing a single WebDriver instance
 * throughout the project's lifecycle. The class ensures global accessibility to the WebDriver
 * instance and offers a clean method for quitting the driver when it is no longer needed.
 *
 * Usage:
 * ------
 * To obtain the WebDriver instance, use the {@link #getDriver()} method. When done with the
 * WebDriver, it is recommended to call the {@link #quitDriver()} method to cleanly close the
 * WebDriver instance and release associated resources.
 *
 * Example:
 * --------
 * ```
 * WebDriver driver = DriverManager.getDriver();
 * Perform automation tasks using the 'driver'
 * DriverManager.quitDriver();
 * ```
 *
 * Benefits:
 * ----------
 * - **Singleton Pattern:**
 *   Ensures a single WebDriver instance, promoting resource efficiency and a centralized
 *   mechanism for managing the driver.
 *
 * - **Global Accessibility:**
 *   The WebDriver instance is globally accessible, simplifying code interactions and making
 *   it easy to control and manipulate WebDriver behavior.
 *
 * - **Clean Quit Mechanism:**
 *   Provides a clean method ({@link #quitDriver()}) for closing the WebDriver instance and
 *   releasing associated resources.
 *
 * Considerations:
 * ---------------
 * - **Resource Utilization:**
 *   In projects with extensive parallel execution requirements, DriverManager might pose
 *   resource challenges.
 *
 * - **Limited Configuration Options:**
 *   Limited flexibility in configuring WebDriver instances based on different browser types.
 *
 * @author Ashik Rabbani
 * @version 1.0
 * @since 2023-11-15
 */
public class DriverManager {
    private static WebDriver driver;

    /**
     * Private constructor to prevent instantiation.
     */
    private DriverManager() {
        // private constructor to prevent instantiation
    }

    /**
     * Get the WebDriver instance. If it doesn't exist, initialize a new one.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize WebDriver (in this case, ChromeDriver)
            // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Quit the WebDriver instance. It is recommended to call this method when the WebDriver
     * is no longer needed to ensure a clean shutdown and release of associated resources.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver instance
        }
    }
}
