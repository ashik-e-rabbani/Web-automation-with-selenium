package com.ashik.sqa.tests;

import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.DriverManager;
import com.ashik.sqa.utils.enums;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingTest {

    private WebDriver driver_predefined, driver_from_factory;


    @BeforeClass
    public void setUp(){
        // Get Predefined driver
        driver_predefined = DriverManager.getDriver();
        // Get Driver Dynamically
        driver_from_factory = BrowserFactory.createDriver(enums.BrowserType.CHROME);
    }

    @Test
    public void DriverFromFactoryTest() throws InterruptedException {
        // Your test logic using the driver from factory
        driver_from_factory.get("https://tallykhata.com");

    }

    @Test (enabled = false)
    public void PredefinedDriverTest() throws InterruptedException {
        // Your test logic using the pre-defined driver
        driver_predefined.get("https://web.tallykhata.com");

    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        DriverManager.quitDriver();
    }

}
