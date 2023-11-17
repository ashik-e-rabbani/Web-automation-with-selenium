package com.ashik.sqa.tests;

import com.ashik.sqa.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverManager.getDriver();
    }

    @Test
    public void LoaderAnimationTest() throws InterruptedException {
        // Your test logic using the driver
        driver.get("https://tallykhata.com");

    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        DriverManager.quitDriver();
    }

}
