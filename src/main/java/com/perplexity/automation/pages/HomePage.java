package com.perplexity.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    // ---- Locators based on visible elements/text ----
    private final By headerMessage = By.tagName("h1");  // "Logged In Successfully"
    private final By successMessage = By.xpath("//*[text()[contains(.,'Congratulations student')]]");
    private final By logoutButton = By.xpath("//button[normalize-space()='Log out']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Get the headline text (e.g., "Logged In Successfully")
    public String getHeaderMessage() {
        return driver.findElement(headerMessage).getText();
    }

    // Get the sub-success message (e.g., "Congratulations student. ...")
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // Clicks the "Log out" button
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    // Returns true if the main login success headline is displayed
    public boolean isLoginSuccessful() {
        return driver.findElement(headerMessage).isDisplayed()
                && getHeaderMessage().equalsIgnoreCase("Logged In Successfully");
    }
}


