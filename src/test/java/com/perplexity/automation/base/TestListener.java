package com.perplexity.automation.base;

import com.perplexity.automation.utils.DriverFactory;
import com.perplexity.automation.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String methodName = result.getMethod().getMethodName();

        // Attach screenshot to Allure report
        ScreenshotUtils.captureScreenshotForAllure(driver);

        // Optionally also save locally
        ScreenshotUtils.captureScreenshot(driver, methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestStart(ITestResult result) {
    }
}
