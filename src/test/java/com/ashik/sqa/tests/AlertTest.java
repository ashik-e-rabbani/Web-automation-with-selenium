package com.ashik.sqa.tests;

import com.ashik.sqa.pages.AlertPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AlertTest {
    private static final Logger log = LogManager.getLogger(AlertTest.class);
    WebDriver driver;
    AlertPage page;


    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        page = new AlertPage(driver);

    }

    @Test(priority = 0, groups = {"regression"})
    @Parameters({"url"})
    public void navigateToPage(@Optional String url) {
        try {
            if (url != null) {
                driver.get(url);
            } else {
                driver.get("https://demoqa.com/alerts");
            }
        } catch (Exception e) {
            log.error("Error occurred when navigating to page. - " + e);
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void testRegularAlert() {
        Assert.assertTrue(page.clickAlertButton());

    }

    @Test(priority = 2)
    public void tesrAlertWithTimer() {
        Assert.assertTrue(page.clickAlertButtonWithTimer());

    }

    @Test(priority = 3)
    public void testAlertAction() {
        Assert.assertTrue(page.clickAlertActionButton());

    }

    @Test(priority = 3)
    public void testPassDataToAction() {
        Assert.assertTrue(page.passDataToAction());

    }

    @AfterClass
    public void tearUp() {
        if (driver != null) {
            BrowserFactory.quitParallelDriver();
        }
    }

}

