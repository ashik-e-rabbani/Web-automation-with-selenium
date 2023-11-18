package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the Sample Page of the application.
 * It contains methods to interact with elements and perform actions on the Sample Page.
 */
public class SamplePage {

    private static final Logger log = LogManager.getLogger(SamplePage.class);
    private WebDriver driver;
    /**
     * Constructor to initialize the SamplePage with a WebDriver instance.
     *
     * @param driver The WebDriver instance to be used for interacting with the Sample Page.
     * It will get the driver instance from the test class and take actions using it.
     */
    public SamplePage(WebDriver driver){
        this.driver = driver;
        log.info("Driver setUp complete from Page");
    }


    public void clickOnSQR() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("menu-item-4390")).click();
    }
}
