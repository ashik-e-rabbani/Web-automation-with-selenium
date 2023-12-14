package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeadlessBrowserPage extends BasePage{
    private static final Logger log = LogManager.getLogger(HeadlessBrowserPage.class);

    @FindBy(css = "p.companyName")
    List<WebElement> jobTitle;

    public HeadlessBrowserPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkJobTitle(){
        log.info(jobTitle);


        // Check each element for the presence of "SQA"
        for (WebElement element : jobTitle) {
            String text = element.getText(); // You can use getText() or getAttribute("innerHTML") based on your HTML structure
            if (text.contains("SQA")) {
                log.info("Element contains 'SQA': " + text);
                return true;
            } else {
                log.info("Element does not contain 'SQA': " + text);
                return false;
            }
        }
        return false;
    }
}
