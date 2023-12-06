package com.ashik.sqa.tests;

import com.ashik.sqa.pages.ButtonInteractionsPage;
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

public class ButtonInteractionsTest {
    private static final Logger log = LogManager.getLogger(ButtonInteractionsTest.class);
    WebDriver driver;
    ButtonInteractionsPage bip;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver.manage().window().maximize();
        bip = new ButtonInteractionsPage(driver);
    }

    @Test(priority = 1)
    public void goToHomePage() throws InterruptedException {
        driver.get("https://demoqa.com/elements");
        Thread.sleep(3000);
    }

    @Test(priority = 2, enabled = true)
    public void NavigatingRadioBtnSection() throws InterruptedException {
        Assert.assertTrue(bip.navigateRadioBtnSection(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 3, enabled = true)
    public void clickedRadioBtn() throws InterruptedException {
        Assert.assertTrue(bip.clickOnRadioBtn(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 4, enabled = true)
    public void interactingWithCheckbox() throws Exception {
        Assert.assertTrue(bip.checkboxBtnInteraction(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 5, enabled = true)
    public void navigateButtonsSection() throws InterruptedException {
        Assert.assertTrue(bip.navigateButtonsSection(), String.valueOf(true));
        Thread.sleep(3000);

    }

    @Test(priority = 6, enabled = true)
    public void buttonDoubleClicked() {
        Assert.assertTrue(bip.isDoubleClicked());
    }

    @Test(priority = 7, enabled = true)
    public void buttonRightClicked() {
        Assert.assertTrue(bip.isRightClicked());
    }

    @Test(priority = 8, enabled = true)
    public void navigateDynamicSection() throws InterruptedException {
        Assert.assertTrue(bip.navigateDynamicSection(), String.valueOf(true));
        Thread.sleep(3000);
    }

    @Test(priority = 9, enabled = true, description = "Will enable N seconds")
    public void delayedEnabledButtonClicked() {
        Assert.assertTrue(bip.delayedEnabledButtonClicked());
    }

    @Test(priority = 10, enabled = true, description = "Visible After N Seconds")
    public void delayedVisibleButtonClicked() {
        Assert.assertTrue(bip.delayedVisibleButtonClicked());
    }


    @AfterClass
    public void tearUp() {
        quitParallelDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
