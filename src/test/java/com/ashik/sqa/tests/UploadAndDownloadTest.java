package com.ashik.sqa.tests;

import com.ashik.sqa.pages.LinkPage;
import com.ashik.sqa.pages.UploadAndDownloadPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class UploadAndDownloadTest {

    private static final Logger log = LogManager.getLogger(UploadAndDownloadTest.class);
    WebDriver driver;
    ChromeOptions chromeOptions;
    UploadAndDownloadPage uadp;

    @BeforeClass
    public void setUp() {
        // Set Chrome options for download preferences
        chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs",
                Map.of("download.default_directory", "/home/ashik/download_by_automation",
                        "download.prompt_for_download", false,
                        "download.directory_upgrade", true,
                        "safebrowsing.enabled", true));

        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME, chromeOptions);
        uadp = new UploadAndDownloadPage(driver);
        log.info("Driver initialized.");

    }

    @Test(priority = 0)
    public void navigateToPage() {
        try {
            driver.get("https://demoqa.com/upload-download");
        } catch (Exception e) {
            log.error("Error occurred when navigating to page. - " + e);
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void downloadImage() {
        Assert.assertTrue(uadp.downloadImage());
    }

    @Test(priority = 2)
    public void uploadFile() {
        Assert.assertTrue(uadp.uploadFile("/home/ashik/Pictures/gift.jpg"));
    }

    @AfterClass
    public void tearUp() {
        if (driver != null) {
            BrowserFactory.quitParallelDriver();
        }
    }
}
