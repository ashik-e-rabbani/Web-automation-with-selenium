package com.ashik.sqa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * BrowserFactory Class
 * <p>
 * This class provides methods to create WebDriver instances for different web browsers.
 * It supports both sequential and parallel test execution using the ThreadLocal pattern
 * for thread safety.
 * <p>
 * Methods:
 * - createDriver: Initializes and returns a WebDriver instance for sequential execution.
 * - createParallelDriver: Initializes and returns a WebDriver instance for parallel execution.
 * - initChromeDriver: Initializes and returns a ChromeDriver instance.
 * - initFirefoxDriver: Initializes and returns a FirefoxDriver instance.
 * - initParallelChromeDriver: Initializes and returns a ChromeDriver instance for parallel execution.
 * - initParallelFirefoxDriver: Initializes and returns a FirefoxDriver instance for parallel execution.
 * - quitParallelDriver: Quits the WebDriver instance created for parallel execution.
 * <p>
 * Usage:
 * - Creating a WebDriver instance for Sequential Execution:
 * WebDriver driver = BrowserFactory.createDriver(enums.BrowserType.CHROME);
 * <p>
 * - Creating a WebDriver instance for Parallel Execution:
 * WebDriver driver = BrowserFactory.createParallelDriver(enums.BrowserType.FIREFOX);
 * <p>
 * - Quitting Parallel WebDriver:
 * BrowserFactory.quitParallelDriver();
 * <p>
 * Note:
 * - Ensure the appropriate WebDriver executables (ChromeDriver, GeckoDriver) are available in the system's PATH.
 * - Additional configurations or settings can be applied within respective methods based on specific requirements.
 */
public class BrowserFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver createDriver(enums.BrowserType browserType) {
        WebDriver driver;

        switch (browserType) {
            case CHROME:
                driver = initChromeDriver();
                break;
            case FIREFOX:
                driver = initFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        // Additional configurations or settings can be applied here

        return driver;
    }

    private static WebDriver initChromeDriver() {
//        Set the path to the ChromeDriver executable for version before Chrome 115 and selenium 4.11
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//
//        Initialize ChromeDriver
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
//        Set the path to the GeckoDriver executable (Firefox driver) before selenium version 4.11
//        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");

//        Initialize FirefoxDriver
        return new FirefoxDriver();
    }

    public static WebDriver createParallelDriver(enums.BrowserType browserType) {
        WebDriver driver;

        switch (browserType) {
            case CHROME:
                driver = initParallelChromeDriver();
                break;
            case FIREFOX:
                driver = initParallelFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        // Additional configurations or settings can be applied here

        return driver;
    }

    private static WebDriver initParallelChromeDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = new ChromeDriver();
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    private static WebDriver initParallelFirefoxDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = new FirefoxDriver();
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }


    public static void quitParallelDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

}
