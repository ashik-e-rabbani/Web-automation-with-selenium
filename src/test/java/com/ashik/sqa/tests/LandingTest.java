package com.ashik.sqa.tests;

import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.DriverManager;
import com.ashik.sqa.utils.enums;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class LandingTest {

    private WebDriver driver_predefined, driver_sequential_from_factory, driver_parallel_from_factory;


    @BeforeClass
    public void setUp(){
        // Get Predefined driver
        driver_predefined = DriverManager.getDriver();

        // Get sequential driver from factory
        driver_sequential_from_factory = BrowserFactory.createDriver(enums.BrowserType.CHROME);

        // Get parallel driver from factory
        driver_parallel_from_factory = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
    }


    @Test (priority = 1,enabled = false, description = "This test will use predefined driver from DriverManager class")
    public void PredefinedDriverTest() throws InterruptedException {
        // Your test logic using the pre-defined driver
        driver_predefined.get("https://web.tallykhata.com");

    }

    @Test (priority = 2,enabled = false, description = "This test will use sequential driver from BrowserFactory class")
    public void SequentialDriverFromFactoryTest() throws InterruptedException {
        // Your test logic using the pre-defined driver
        driver_sequential_from_factory.get("https://tallykhata.com");

    }
    @Test(priority = 3, description = "This will use parallel driver from BrowserFactory class")
    public void ParallelDriverFromFactoryTest() throws InterruptedException {
        // Your test logic using the driver from factory
        driver_parallel_from_factory.get("https://ashik-e-rabbani.github.io");

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
