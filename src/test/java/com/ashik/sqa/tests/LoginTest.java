package com.ashik.sqa.tests;
/**
 * Test class for the login functionality.
 * <p>
 * This class contains test methods to validate the login process.
 * It utilizes TestNG annotations for test configuration, setup, and cleanup.
 * The tests cover basic navigation, checking identity, and clicking on sign-in related elements.
 * </p>
 *
 * <p><b>Annotations Used:</b></p>
 * <ul>
 *     <!-- ... (previous annotations) ... -->
 * </ul>
 *
 * <p><b>Using Groups Attribute:</b></p>
 * <p>
 * The {@code groups} attribute is utilized to categorize test methods. This categorization helps in
 * running specific sets of tests based on their groupings. In this class, the following groups are used:
 * </p>
 * <ul>
 *     <li>"sanity": Includes tests related to basic and essential functionalities.</li>
 *     <li>"regression": Includes tests that check if existing functionalities are still working after new changes.</li>
 * </ul>
 * <p>
 * During test execution, you can choose to run tests belonging to specific groups using TestNG configurations.
 * To execute tests based on groups, create a TestNG XML file and specify the groups to include or exclude.
 * </p>
 * <p><b>Example TestNG XML:</b></p>
 * <pre>{@code
 * <suite name="LoginTestSuite">
 *     <test name="LoginTests">
 *         <groups>
 *             <run>
 *                 <include name="sanity" />
 *                 <!-- Uncomment the line below to include "regression" tests as well -->
 *                 <!-- <include name="regression" /> -->
 *             </run>
 *         </groups>
 *         <classes>
 *             <class name="com.ashik.sqa.tests.LoginTest" />
 *             <!-- Include other test classes if needed -->
 *         </classes>
 *     </test>
 * </suite>
 * }</pre>
 * <p>
 * In the above example, only tests belonging to the "sanity" group will be executed. Modify the XML
 * to include or exclude different groups based on your testing requirements.
 * </p>
 *
 * @see BeforeClass
 * @see BeforeMethod
 * @see Test
 * @see AfterClass
 * @see BrowserFactory
 * @see LoginPage
 */

import com.ashik.sqa.pages.LoginPage;
import com.ashik.sqa.utils.BrowserFactory;
import com.ashik.sqa.utils.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ashik.sqa.utils.BrowserFactory.quitParallelDriver;

public class LoginTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);
    WebDriver driver;
    LoginPage lp;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.createParallelDriver(enums.BrowserType.CHROME);
        driver.manage().window().maximize();

        lp = new LoginPage(driver);
        log.info("Driver Initiated");
    }

    @BeforeMethod
    public void checkIdentity() {
        driver.getCurrentUrl();
        log.info("checkIdentity");
    }

    @Test(priority = 1,
            description = "Checking we are in correct url or not.",
            groups = {"sanity", "regression"})
    public void goToHomePage() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    public void clickOnSignInSectionTest() throws InterruptedException {
        Assert.assertTrue(lp.clickOnSingInSection());
    }

    @Test(priority = 3, description = "Clicking on sign-in button", groups = "regression")
    public void checkAlreadyInSingInPage() {
        Assert.assertTrue(lp.checkAlreadyInSingInPage());
    }


    @Test(priority = 3, description = "Clicking on sign-in button", groups = "regression", dependsOnMethods = {"checkAlreadyInSingInPage"})
    public void clickOnSignInButtonTest() {
        Assert.assertTrue(lp.clickOnSingInButton());
    }

    @AfterClass
    public void tearUp() {
        quitParallelDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
