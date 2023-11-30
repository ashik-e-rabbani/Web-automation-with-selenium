package com.ashik.sqa.tests;

import com.ashik.sqa.pages.InteractionsPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.LocatorInfo;
import com.ashik.sqa.utils.ScriptBuilder;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class draft {
    private static final Logger log = LogManager.getLogger(draft.class);
    static WebDriver driver;
    InteractionsPage ip;

    @FindBy(id ="tree-node-home")
    WebElement checkboxHome;


    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver.manage().window().maximize();
        ip = new InteractionsPage(driver);
    }

    @Test(priority = 1)
    public void goToHomePage() throws Exception {



    }






    @AfterClass
    public void tearUp() {
        quitParallelDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
