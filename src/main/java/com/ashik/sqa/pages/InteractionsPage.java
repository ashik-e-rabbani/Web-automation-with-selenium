package com.ashik.sqa.pages;

import com.ashik.sqa.utils.ScriptBuilder;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class InteractionsPage extends BasePage {
    private static final Logger log = LogManager.getLogger(InteractionsPage.class);
    JavascriptExecutor js;
    @FindBy(id = "item-2")
    WebElement radioBtnSection;

    @FindBy(id = "yesRadio")
    WebElement yesRadio;

    @FindBy(id = "item-1")
    WebElement checkboxSection;
    @FindBy(id ="tree-node-home")
    WebElement checkboxHome;

    public InteractionsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public boolean radioBtnInteraction() throws InterruptedException {
        navigateRadioBtnSection();

        if (yesRadio.isDisplayed()) {
            yesRadio.click();
        } else {
            try {
                log.info("Trying to click radio button via JavaScript");
                // Create a JavascriptExecutor object
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Execute the JavaScript command to click the radio button
                js.executeScript(ScriptBuilder.buildScript(InteractionsPage.class,"yesRadio", "",enums.ActionType.CLICK));

                return isRadioBtnSelected();
            } catch (Exception e) {
                log.error("Radio button is not visible", e);
                return false;
            }
        }
        return false;

    }

    private void navigateRadioBtnSection() {
        if (radioBtnSection.isDisplayed()) {
            radioBtnSection.click();
        } else {
            log.error("Radio Section is not visible");
        }

    }

    private boolean isRadioBtnSelected() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeSelected(yesRadio));
            return true;
        } catch (Exception e) {
            log.error("Radio button is not selected", e);
            return false;
        }


    }

    public boolean checkboxBtnInteraction() throws Exception {

        navigateCheckboxSection();
        if (checkboxHome.isDisplayed()) {
            checkboxHome.click();
        } else {
            log.info("Not displaying checkbox");
            // Execute the JavaScript command to click the checkbox
            js.executeScript(ScriptBuilder.buildScriptClick(InteractionsPage.class,"checkboxHome"));
        }

        return isCheckboxSelected();
    }

    private void navigateCheckboxSection() {
        if (checkboxSection.isDisplayed()) {
            checkboxSection.click();
        } else {
            log.error("Checkbox Section is not visible");
        }

    }

    private boolean isCheckboxSelected() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeSelected(checkboxHome));
            return true;
        } catch (Exception e) {
            log.error("Checkbox is not selected", e);
            return false;
        }


    }

}



