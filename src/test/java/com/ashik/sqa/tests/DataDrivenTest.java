package com.ashik.sqa.tests;

import com.ashik.sqa.DataDrivenPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Feature("Your Feature")
@Story("Your Story")
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

    @DataProvider(name = "csvData")
    public Object[][] readCSVData() throws IOException {
        List<String[]> data = new ArrayList<>();

        // Replace "path/to/your/file.csv" with the actual path to your CSV file
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/testdata/testCsvData.csv"))) {
            data = csvReader.readAll();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return data.toArray(new Object[0][0]);
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

    @Test(enabled = false, priority = 2, groups = {"regression"}, dataProvider = "csvData")
    public void testDataFromCSV(String column1, String column2, String column3) {
        // Your test logic using the provided parameters
        log.info("Column 1: " + column1);
        log.info("Column 2: " + column2);
        log.info("Column 3: " + column3);

        // Example: Checking multiple conditions using soft asserts
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(column1, "ashik", "Values do not match");
        softAssert.assertEquals(column2, "28", "Values do not match");


        // Additional soft asserts as needed

        // Report all failures at the end of the test
        softAssert.assertAll();
    }

    @AfterClass
    public void tearUp() {
        if (driver != null) {
            BrowserFactory.quitParallelDriver();
        }
    }
}
