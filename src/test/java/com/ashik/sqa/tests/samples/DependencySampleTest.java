package com.ashik.sqa.tests.samples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencySampleTest {

    @Test
    public void loginTest() {
        // Logic for login test
        System.out.println("Executing Login Test");
    }

    @Test(dependsOnMethods = "loginTest")
    public void homePageTest() {
        // Logic for home page test, which depends on the login test
        System.out.println("Executing Home Page Test");
        Assert.fail("Simulated test failure: This test should fail");
    }

    @Test(dependsOnMethods = {"loginTest", "homePageTest"})
    public void searchTest() {
        // Logic for search test, which depends on both login and home page tests
        System.out.println("Executing Search Test");
    }
}