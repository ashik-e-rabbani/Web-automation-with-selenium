package com.ashik.sqa.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadAndDownloadPage extends BasePage {
    private static final Logger log = LogManager.getLogger(LinkPage.class);
    JavascriptExecutor js;

    @FindBy(id = "downloadButton")
    WebElement downloadImageBtn;

    @FindBy(id = "uploadFile")
    WebElement uploadBtn;
    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public boolean downloadImage() {
        try {
            downloadImageBtn.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean uploadFile(String path) {
        try {
            uploadBtn.sendKeys(path);
            Thread.sleep(1000);
            return uploadedFilePath.getText().contains("gift");

        } catch (Exception e) {
            return false;
        }
    }
}
