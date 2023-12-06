package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * BasePage class serves as the foundation for all page classes in the test framework.
 * It encapsulates common functionality and initializes elements using the PageFactory pattern.
 *
 * Features:
 * - Provides a WebDriver instance to subclasses for interaction with the browser.
 * - Uses PageFactory to initialize elements, enhancing code reusability and maintainability.
 * - Offers a common method, navigateTo, for straightforward navigation to a specified URL.
 *
 * Usage:
 * - Extend this class to create page classes for specific web pages.
 * - Leverage the WebDriver instance for browser interaction in subclasses.
 * - Utilize the navigateTo method to easily navigate to different URLs.
 *
 * Example:
 * {@code
 * public class LoginPage extends BasePage {
 *     // Specific elements and methods for the Login page
 * }
 * }
 *
 * Note: Ensure the WebDriver instance is set before creating subclasses of BasePage.
 */
public class BasePage {
    protected WebDriver driver;
    private static final Logger log = LogManager.getLogger(BasePage.class);
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Accepting the child driver param and creating instance");
    }

    // Common method for navigation
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Other common methods can be added as needed
}