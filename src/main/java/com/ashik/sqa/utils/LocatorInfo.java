package com.ashik.sqa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for extracting locator information from WebElement fields annotated with @FindBy.
 * Developed by Ashik Rabbani
 * https://github.com/ashik-e-rabbani
 */
public class LocatorInfo {
    private static final Logger log = LogManager.getLogger(LocatorInfo.class);

    /**
     * Gets the locator information for a WebElement field.
     *
     * @param pageClass The class containing the WebElement field.
     * @param fieldName The name of the WebElement field.
     * @return A map containing the locator type and value.
     */
    public static Map<String, String> getLocatorInfo(Class<?> pageClass, String fieldName) {
        try {
            Field field = pageClass.getDeclaredField(fieldName);
            FindBy findByAnnotation = field.getAnnotation(FindBy.class);

            if (findByAnnotation != null) {
                return extractLocatorInfo(findByAnnotation.toString());
            } else {
                log.error("No @FindBy annotation found for field: " + fieldName);
                return new HashMap<>();
            }
        } catch (NoSuchFieldException e) {
            log.error("Field not found: " + fieldName, e);
            return new HashMap<>();
        } catch (Exception e) {
            log.error("Error extracting locator information for field: " + fieldName, e);
            return new HashMap<>();
        }
    }

    /**
     * Extracts locator information from the @FindBy annotation string.
     *
     * @param input The input string containing the @FindBy annotation.
     * @return A map containing the locator type and value.
     */
    private static Map<String, String> extractLocatorInfo(String input) {
        Map<String, String> locatorInfo = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\w+)=\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            if (!value.isEmpty()) {
                locatorInfo.put("locatorType", key);
                locatorInfo.put("locatorValue", value);
                break; // Assuming you want to stop after the first non-empty value
            }
        }

        return locatorInfo;
    }
}