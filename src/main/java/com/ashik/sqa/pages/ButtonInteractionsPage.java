package com.ashik.sqa.pages;

import com.ashik.sqa.utils.ScriptBuilder;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class ButtonInteractionsPage extends BasePage {
    private static final Logger log = LogManager.getLogger(ButtonInteractionsPage.class);
    JavascriptExecutor js;
    @FindBy(id = "item-2")
    WebElement radioBtnSection;

    @FindBy(id = "yesRadio")
    WebElement yesRadio;

    @FindBy(id = "item-1")
    WebElement checkboxSection;
    @FindBy(id = "tree-node-home")
    WebElement checkboxHome;
    @FindBy(id = "item-4")
    WebElement btnSection;
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;
    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    @FindBy(id = "item-8")
    WebElement dynamicPropSection;
    @FindBy(id = "enableAfter")
    WebElement enableAfter;
    @FindBy(id = "visibleAfter")
    WebElement visibleAfter;

    public ButtonInteractionsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    public boolean navigateRadioBtnSection() {
        if (radioBtnSection.isDisplayed()) {
            radioBtnSection.click();
            return true;
        } else {
            log.error("Radio Section is not visible");
            return false;
        }


    }

    public boolean clickOnRadioBtn() throws InterruptedException {
        if (yesRadio.isDisplayed()) {
            yesRadio.click();
        } else {
            try {
                log.info("Trying to click radio button via JavaScript");
                // Create a JavascriptExecutor object
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Execute the JavaScript command to click the radio button
                js.executeScript(ScriptBuilder.buildScript(ButtonInteractionsPage.class, "yesRadio", "", enums.ActionType.CLICK));

                return isRadioBtnSelected();
            } catch (Exception e) {
                log.error("Radio button is not visible", e);
                return false;
            }
        }
        return false;

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

    private void navigateCheckboxSection() {
        if (checkboxSection.isDisplayed()) {
            checkboxSection.click();
        } else {
            log.error("Checkbox Section is not visible");
        }

    }

    public boolean checkboxBtnInteraction() throws Exception {

        navigateCheckboxSection();
        if (checkboxHome.isDisplayed()) {
            checkboxHome.click();
        } else {
            log.info("Not displaying checkbox");
            // Execute the JavaScript command to click the checkbox
            js.executeScript(ScriptBuilder.buildScriptClick(ButtonInteractionsPage.class, "checkboxHome"));
        }

        return isCheckboxSelected();
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

    public boolean navigateButtonsSection() {
        if (btnSection.isDisplayed()) {
            btnSection.click();
            return true;
        } else {
            log.error("Button Section is not visible");
            return false;
        }

    }

    public boolean isDoubleClicked() {

        if (doubleClickBtn.isDisplayed()) {
            log.error("Button is visible");
            // Create an Actions object
            Actions actions = new Actions(driver);

            // Perform a double-click on the button
            actions.doubleClick(doubleClickBtn).perform();

            return doubleClickMessage.getText().contains("You have done a double click");
        }
        log.error("Button is not visible");
        return false;

    }

    public boolean isRightClicked() {

        if (rightClickBtn.isDisplayed()) {
            log.error("Right Button is visible");
            // Create an Actions object
            Actions actions = new Actions(driver);

            // Perform a right-click on the element
            actions.contextClick(rightClickBtn).perform();

            return rightClickMessage.getText().contains("You have done a right click");
        }
        log.error("Right Button is not visible");
        return false;

    }

    public boolean navigateDynamicSection() {

        // Scroll to the element using JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicPropSection);

        if (dynamicPropSection.isDisplayed()) {
            dynamicPropSection.click();
            return true;
        } else {
            log.error("dynamicProp Section is not visible");
            return false;
        }

    }

    public boolean delayedEnabledButtonClicked() {
        // Use WebDriverWait to wait for the visibility of the element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use the @FindBy WebElement directly without casting to (By)
        WebElement delayedEnabled = wait.until(ExpectedConditions.elementToBeClickable(enableAfter));


        if (enableAfter.isDisplayed() & enableAfter.isEnabled()) {
            log.info("Delayed Button is visible and enable");
            delayedEnabled.click();
            return true;
        } else {
            log.error("Delayed Button is not visible or enable");
            return false;
        }

    }

    public boolean delayedVisibleButtonClicked() {
        try {
            // Use WebDriverWait to wait for the visibility of the element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Use the @FindBy WebElement directly without casting to (By)
            WebElement delayedElement = wait.until(ExpectedConditions.visibilityOf(visibleAfter));

            if (delayedElement.isDisplayed()) {
                log.info("delayedElement Button is visible");
                visibleAfter.click();
                return true;
            }
            log.info("delayedElement Button is not visible");
            return false;
        } catch (Exception e) {
            log.error("Exception occurred: " + e.getMessage());
            return false;
        }
    }


}



