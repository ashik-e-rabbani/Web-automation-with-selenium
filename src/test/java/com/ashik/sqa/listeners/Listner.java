package com.ashik.sqa.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listner implements ITestListener {

@Override
public void onTestSuccess(ITestResult result) {
    System.out.println("^^^^___^^^^^ Test Passed: " + result.getName());
}

@Override
public void onTestFailure(ITestResult result) {
    System.out.println("Test Failed: " + result.getName());
    // Implement actions to take on test failure (e.g., take a screenshot)
}
}



