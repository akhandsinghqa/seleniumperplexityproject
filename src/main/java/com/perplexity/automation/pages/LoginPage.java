package com.perplexity.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage(driver);
    }

    public HomePage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginButton);
    }
}
