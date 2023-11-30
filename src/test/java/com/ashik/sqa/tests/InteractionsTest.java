package com.ashik.sqa.tests;

import com.ashik.sqa.pages.InteractionsPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class InteractionsTest {
    private static final Logger log = LogManager.getLogger(InteractionsTest.class);
    WebDriver driver;
    InteractionsPage ip;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver.manage().window().maximize();
        ip = new InteractionsPage(driver);
    }

    @Test(priority = 1)
    public void goToHomePage() throws InterruptedException {
        driver.get("https://demoqa.com/elements");
        Thread.sleep(3000);
    }

    @Test(priority = 2, enabled = true)
    public void testUnClickableRadioBtnInteraction() throws InterruptedException {
        Assert.assertTrue(ip.radioBtnInteraction(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 3, enabled = true)
    public void testIsRadioBtnClicked() throws InterruptedException {
        Assert.assertTrue(ip.radioBtnInteraction(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 4, enabled = true)
    public void testCheckboxBtnInteraction() throws Exception {
        Assert.assertTrue(ip.checkboxBtnInteraction(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearUp() {
        quitParallelDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
