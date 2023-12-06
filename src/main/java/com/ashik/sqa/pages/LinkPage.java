package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LinkPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LinkPage.class);
    JavascriptExecutor js;
    @FindBy(linkText = "Created")
    WebElement createdLink;
    @FindBy(partialLinkText = "Bad")
    WebElement partialLink;
    @FindBy(id = "item-2")
    WebElement radioBtnSection;
    @FindBy(css = "Bad")
    WebElement linkAttributeCss;
    @FindBy(linkText = "Home")
    WebElement newTabLink;

    @FindBy(css = "div p a")
    WebElement dynamicLinks;
    @FindBy(id = "linkResponse")
    WebElement linkResponse;

    public LinkPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public boolean basicLink() throws InterruptedException {

        if (createdLink.isDisplayed()) {
            Thread.sleep(2000);
            createdLink.click();
            Thread.sleep(1000);
            return linkResponse.getText().contains("staus 201 and status text Created");
        }

        return false;
    }

    public boolean partialLink() throws InterruptedException {

        if (partialLink.isDisplayed()) {
            Thread.sleep(2000);
            partialLink.click();
            Thread.sleep(1000);
            return linkResponse.getText().contains("staus 400");
        }

        return false;
    }

    public boolean linkWithAttributes() throws InterruptedException {

        if (linkAttributeCss.isDisplayed()) {
            linkAttributeCss.click();
            Thread.sleep(1000);
            return linkResponse.getText().contains("staus 200");
        }

        return false;
    }

    public boolean linkInNewTab() {

        if (newTabLink.isDisplayed()) {
            String linkUrl = newTabLink.getAttribute("href");
            js.executeScript("window.open('" + linkUrl + "','_blank');");
            return true;
        }

        return false;
    }

    public boolean dynamicLink() {

        if (dynamicLinks.isDisplayed()) {
            List<WebElement> dynamicLinkList = (List<WebElement>) dynamicLinks;
            for (WebElement link : dynamicLinkList) {
                log.info(link.getText()); // Print text of each link
            }
            return true;
        }

        return false;
    }

    public boolean redirectLink() throws InterruptedException {

        if (radioBtnSection.isDisplayed()) {
            radioBtnSection.click();
            Thread.sleep(5000);
            return driver.getCurrentUrl().contains("radio");
        }

        return false;
    }

}
