package com.ashik.sqa.utils;

import java.util.Map;

/**
 * Utility class for building JavaScript scripts based on locator information and actions.
 * Developed by Ashik Rabbani
 * https://github.com/ashik-e-rabbani
 */
public class ScriptBuilder {

    /**
     * Builds a JavaScript script based on the specified action type.
     *
     * @param pageClass   The class containing the WebElement.
     * @param fieldName   The name of the WebElement field.
     * @param fieldValue  The field value, applicable for certain actions like SEND_KEYS.
     * @param actionType  The type of action to perform (CLICK, SEND_KEYS, etc.).
     * @return The generated JavaScript script.
     * @throws Exception If the action type is not supported or if there is an issue building the script.
     */
    public static String buildScript(Class<?> pageClass, String fieldName, String fieldValue, enums.ActionType actionType) throws Exception {
        switch (actionType) {
            case CLICK:
                return buildScriptClick(pageClass, fieldName);
            case SEND_KEYS:
                return buildScriptSendKeys(pageClass, fieldName, fieldValue);
            default:
                throw new UnsupportedOperationException("Unsupported action type: " + actionType);
        }
    }

    /**
     * Builds a JavaScript script for the 'click' action.
     *
     * @param pageClass The class containing the WebElement.
     * @param fieldName The name of the WebElement field.
     * @return The generated JavaScript script.
     * @throws Exception If there is an issue building the script.
     */
    public static String buildScriptClick(Class<?> pageClass, String fieldName) throws Exception {
        Map<String, String> locatorInfo = LocatorInfo.getLocatorInfo(pageClass, fieldName);
        String locatorType = "id"; // default value
        String locatorValue = null;

        if (locatorInfo != null) {
            locatorType = locatorInfo.get("locatorType");
            locatorValue = locatorInfo.get("locatorValue");
        } else {
            throw new Exception("Locator information not found for field: " + fieldName);
        }

        // Building the JavaScript script based on locator type and value
        return buildScriptCommon(locatorType, locatorValue, "click");
    }

    /**
     * Builds a JavaScript script for the 'sendKeys' action.
     *
     * @param pageClass  The class containing the WebElement.
     * @param fieldName  The name of the WebElement field.
     * @param fieldValue The field value for sending keys.
     * @return The generated JavaScript script.
     * @throws Exception If there is an issue building the script.
     */
    public static String buildScriptSendKeys(Class<?> pageClass, String fieldName, String fieldValue) throws Exception {
        Map<String, String> locatorInfo = LocatorInfo.getLocatorInfo(pageClass, fieldName);
        String locatorType = "id"; // default value
        String locatorValue = null;

        if (locatorInfo != null) {
            locatorType = locatorInfo.get("locatorType");
            locatorValue = locatorInfo.get("locatorValue");
        } else {
            throw new Exception("Locator information not found for field: " + fieldName);
        }

        // Building the JavaScript script based on locator type and value
        return buildScriptCommon(locatorType, locatorValue, "sendKeys", "'" + fieldValue + "'");
    }

    /**
     * Builds a common JavaScript script based on locator type and action.
     *
     * @param locatorType        The type of locator (id, xpath, etc.).
     * @param locatorValue       The value of the locator.
     * @param action             The action to perform (click, sendKeys, etc.).
     * @param additionalParams   Additional parameters to be included in the script.
     * @return The generated JavaScript script.
     * @throws UnsupportedOperationException If the locator type is not supported.
     */
    private static String buildScriptCommon(String locatorType, String locatorValue, String action, String... additionalParams) {
        switch (locatorType) {
            case "id":
                return String.format("document.getElementById('%s').%s(%s)", locatorValue, action, String.join(",", additionalParams));
            case "xpath":
                return String.format("document.evaluate('%s', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.%s(%s)", locatorValue, action, String.join(",", additionalParams));
            case "partialLinkText":
                return String.format("document.querySelector('a[href*=\"%s\"]').%s(%s)", locatorValue, action, String.join(",", additionalParams));
            case "css":
                return String.format("document.querySelector('%s').%s(%s)", locatorValue, action, String.join(",", additionalParams));
            // Add cases for other supported locator types (className, name, etc.) if needed
            default:
                throw new UnsupportedOperationException("Unsupported locator type: " + locatorType);
        }
    }
}
