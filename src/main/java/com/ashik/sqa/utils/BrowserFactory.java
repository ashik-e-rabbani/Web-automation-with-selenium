package com.ashik.sqa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {



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
        // Set the path to the ChromeDriver executable for version before Chrome 115 and selenium 4.11
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        // Set the path to the GeckoDriver executable (Firefox driver) selenium 4.11
//        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");

        // Initialize FirefoxDriver
        return new FirefoxDriver();
    }

}
