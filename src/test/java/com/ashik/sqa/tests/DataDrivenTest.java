package com.ashik.sqa.tests;

import com.ashik.sqa.DataDrivenPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DataDrivenTest {

    private static final Logger log = LogManager.getLogger(DataDrivenTest.class);
    WebDriver driver;
    DataDrivenPage page;

    // This method provides data to the test method, and testng typically works with 2D array.
    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"Google", "Selenium"},
                {"Bing", "TestNG"},
                {"Yahoo", "WebDriver"}
        };
    }

    @BeforeClass
    public void setUp()
    {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        page = new DataDrivenPage(driver);

    }
    @Test(priority = 0, groups = {"regression"})
    @Parameters({"url"})
    public void navigateToPage(@Optional String url) {
        try {
            if (url != null) {
                driver.get(url);
            } else {
                driver.get("https://google.com");
            }
        } catch (Exception e) {
            log.error("Error occurred when navigating to page. - " + e);
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1, groups = {"regression"}, dataProvider = "searchData")
    public void sendDataViaTestNgDataProvider(String providersData, String data2) {
        log.info(providersData);
    }

    @AfterClass
    public void tearUp() {
        if (driver != null) {
            BrowserFactory.quitParallelDriver();
        }
    }
}
