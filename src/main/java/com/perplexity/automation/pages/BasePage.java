package com.perplexity.automation.pages;

import com.perplexity.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return WaitUtils.waitForVisibility(driver, locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }
}

