package com.ashik.sqa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @CacheLookup
    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement signInSection;

    @FindBy(id = "nav-flyout-ya-signin")
    private WebElement signIn;

    @FindBy(xpath = "//h[contains(text(), 'Sign In')]")
    private WebElement alreadyInSignIn;


    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public boolean clickOnSingInSection() throws InterruptedException {
        signInSection.click();
        Thread.sleep(1500);
        return true;
    }

    public boolean checkAlreadyInSingInPage() {

        if (alreadyInSignIn != null)
        {
            log.info("Already in Signin Page");
            return true;
        }else {
            log.info("Navigating to Signin Page");
            return false;
        }
    }


    public boolean clickOnSingInButton(){
        signIn.click();
        return true;
    }

}
