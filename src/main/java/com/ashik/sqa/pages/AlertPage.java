package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BasePage {
    private static final Logger log = LogManager.getLogger(AlertPage.class);
    JavascriptExecutor js;

    @FindBy(id = "alertButton")
    WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement actionAlert;
    @FindBy(id = "promtButton")
    WebElement promtButton;
    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    public boolean clickAlertButton() {
        alertButton.click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert
        String alertText = alert.getText();
        log.info(alertText);
        if (alertText.contains("You clicked a button")) {
            // Accept the alert (click OK)
            alert.accept();
            return true;
        } else {
            return false;
        }

    }

    public boolean clickAlertButtonWithTimer() {
        timerAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Wait for the alert to be present & Switch to the alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Get the text of the alert
        String alertText = alert.getText();
        log.info(alertText);
        if (alertText.contains("This alert appeared after 5 seconds")) {
            // Accept the alert (click OK)
            alert.accept();
            return true;
        } else {
            return false;
        }

    }

    public boolean clickAlertActionButton() {
        actionAlert.click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert
        String alertText = alert.getText();
        log.info(alertText);
        if (alertText.contains("Do you confirm action?")) {
            // Accept the alert (click OK)
            alert.dismiss();
            return true;
        } else {
            return false;
        }

    }

    public boolean passDataToAction() {
        promtButton.click();
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert
        String alertText = alert.getText();
        log.info(alertText);
        if (alertText.contains("Please enter your name")) {
            alert.sendKeys("Ashik");
            alert.accept();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(promptResult));

            return promptResult.getText().contains("Ashik");
        } else {
            return false;
        }

    }
}
