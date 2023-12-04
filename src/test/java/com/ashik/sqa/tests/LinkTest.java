package com.ashik.sqa.tests;

import com.ashik.sqa.pages.LinkPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class LinkTest {

    private static final Logger log = LogManager.getLogger(LinkTest.class);
    WebDriver driver;
    LinkPage lp;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver.manage().window().maximize();
        lp = new LinkPage(driver);
        log.info("Driver Initiated.");
    }

    @Test(priority = 0)
    public void navigateToPage() {
        try {
            driver.get("https://demoqa.com/links/");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1, enabled = true, description = "Basic Link (Anchor <a> Element):")
    public void basicLink() throws InterruptedException {
        Assert.assertTrue(lp.basicLink());
    }

    @Test(priority = 2, enabled = true, description = "Link with Partial Text")
    public void partialLink() throws InterruptedException {
        Assert.assertTrue(lp.partialLink());
    }

    @Test(priority = 3, enabled = true, description = "Link with Specific Attribute")
    public void linkWithAttributes() throws InterruptedException {
        Assert.assertTrue(lp.linkWithAttributes());
    }

    @Test(priority = 4, enabled = true, description = "Open Link in New Tab or Window")
    public void linkInNewTab() {
        Assert.assertTrue(lp.linkInNewTab());
    }

    @Test(priority = 5, enabled = false, description = " Working with Dynamic Links")
    public void dynamicLink() {
        Assert.assertTrue(lp.dynamicLink());
    }

    @Test(priority = 6, enabled = true, description = "Redirecting URL")
    public void redirectLink() throws InterruptedException {
        Assert.assertEquals(lp.redirectLink(), true);
    }

    @AfterClass
    public void tearUp() {
        quitParallelDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
