package com.perplexity.automation.utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for capturing screenshots and attaching to Allure reports.
 */
public final class ScreenshotUtils {

    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/screenshots/";

    // Private constructor to prevent instantiation
    private ScreenshotUtils() {
    }

    /**
     * Captures a screenshot of the current browser window and saves it to the screenshot folder.
     *
     * @param driver   the WebDriver instance
     * @param testName the name of the test method
     * @return the full path of the saved screenshot
     */
    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = testName + "_" + timestamp + ".png";
        String destPath = SCREENSHOT_FOLDER + filename;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(destPath));
            System.out.println("Screenshot saved at: " + destPath);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        return destPath;
    }

    /**
     * Captures and attaches a screenshot directly to the Allure report.
     *
     * @param driver the WebDriver instance
     * @return the byte array of the screenshot for Allure
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshotForAllure(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


