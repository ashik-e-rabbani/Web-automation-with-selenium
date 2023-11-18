package com.ashik.sqa.tests;

import com.ashik.sqa.pages.SamplePage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class SampleTest {

    private static final Logger log = LogManager.getLogger(SampleTest.class);
    private WebDriver driver_predefined, driver_sequential_from_factory, driver_parallel_from_factory;

    private SamplePage samplePage;

    @BeforeClass
    public void setUp(){
        // Get Predefined driver
//        driver_predefined = DriverManager.getDriver();

        // Get sequential driver from factory
//        driver_sequential_from_factory = BrowserFactory.createDriver(enums.BrowserType.CHROME);

        // Get parallel driver from factory
        driver_parallel_from_factory = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver_parallel_from_factory.manage().window().maximize();

        samplePage = new SamplePage(driver_parallel_from_factory);

        log.info("Driver setUp complete.");
    }


    @Test (priority = 1,enabled = false, description = "This test will use predefined driver from DriverManager class")
    public void PredefinedDriverTest() throws InterruptedException {
        // Your test logic using the pre-defined driver
        driver_predefined.get("https://web.tallykhata.com");
        log.info("PredefinedDriverTest executed successfully.");

    }

    @Test (priority = 2,enabled = false, description = "This test will use sequential driver from BrowserFactory class")
    public void SequentialDriverFromFactoryTest() throws InterruptedException {
        // Your test logic using the pre-defined driver
        driver_sequential_from_factory.get("https://tallykhata.com");
        log.info("SequentialDriverFromFactoryTest executed successfully.");

    }
    @Test(priority = 3, description = "This will use parallel driver from BrowserFactory class")
    public void ParallelDriverFromFactoryTest() throws InterruptedException {
        // Your test logic using the driver from factory
        driver_parallel_from_factory.get("https://www.tallykhata.com");
        log.info("ParallelDriverFromFactoryTest executed successfully.");

    }

    @Test(priority = 4)
    public void SQRClickTest() throws InterruptedException {
        samplePage.clickOnSQR();
    }
    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance;
        quitParallelDriver();
        if (driver_parallel_from_factory != null){
            driver_parallel_from_factory.quit();
        }
    }

}
