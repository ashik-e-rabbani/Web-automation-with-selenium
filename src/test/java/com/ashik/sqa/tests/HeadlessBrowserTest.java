package com.ashik.sqa.tests;

import com.ashik.sqa.pages.HeadlessBrowserPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowserTest {

    WebDriver driver;
    // Create ChromeOptions and set headless mode
    ChromeOptions options;
    HeadlessBrowserPage page;
    @BeforeClass
    public void setUp(){
        options = new ChromeOptions();
        options.addArguments("--headless");
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME,options);
        page = new HeadlessBrowserPage(driver);
    }

    @Test(priority = 1)
    public void launchHeadlessBrowser(){
        driver.get("https://ashik-e-rabbani.github.io/");
    }

    @Test(priority = 2)
    public void checkJobTitle()
    {
        Assert.assertTrue(page.checkJobTitle());
    }
}
