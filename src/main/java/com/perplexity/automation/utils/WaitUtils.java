package com.perplexity.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for handling explicit waits in Selenium WebDriver tests.
 */
public final class WaitUtils {

    private static final int DEFAULT_WAIT_SECONDS = ConfigReader.getInstance().getExplicitWait();

    // Prevent instantiation
    private WaitUtils() {
    }

    /**
     * Waits until the given element is visible on the page.
     *
     * @param driver  WebDriver instance
     * @param locator By locator of the WebElement
     * @param seconds Timeout in seconds
     * @return WebElement when visible
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until the given element is clickable on the page.
     *
     * @param driver  WebDriver instance
     * @param locator By locator of WebElement
     * @param seconds Timeout in seconds
     * @return WebElement when clickable
     */
    public static WebElement waitForClickability(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for presence of an element located by the given locator.
     *
     * @param driver  WebDriver instance
     * @param locator By locator of WebElement
     * @param seconds Timeout in seconds
     * @return WebElement when present in DOM
     */
    public static WebElement waitForPresence(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits until the text is present in the given element.
     *
     * @param driver  WebDriver instance
     * @param locator By locator of WebElement
     * @param text    Text to be present
     * @param seconds Timeout in seconds
     * @return true if text appears, false otherwise
     */
    public static boolean waitForTextInElement(WebDriver driver, By locator, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Waits until the element is visible (default timeout).
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return waitForVisibility(driver, locator, DEFAULT_WAIT_SECONDS);
    }

    /**
     * Waits until the element is clickable (default timeout).
     */
    public static WebElement waitForClickability(WebDriver driver, By locator) {
        return waitForClickability(driver, locator, DEFAULT_WAIT_SECONDS);
    }

    /**
     * Waits until the element is present (default timeout).
     */
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return waitForPresence(driver, locator, DEFAULT_WAIT_SECONDS);
    }
}


