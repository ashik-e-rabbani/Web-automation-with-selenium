package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean goToHomePage() throws InterruptedException {
    driver.get("https://www.amazon.com/");
    Thread.sleep(3000);
    return true;
    }

    public boolean checkBaseUrl() {
        driver.getCurrentUrl();
        return true;
    }

    public boolean clickOnSingInSection() throws InterruptedException {
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        Thread.sleep(1500);
        return true;
    }

    public boolean clickOnSingInButton(){
        driver.findElement(By.id("nav-flyout-ya-signin")).click();
        return true;
    }

}
