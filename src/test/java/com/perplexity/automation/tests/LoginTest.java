package com.perplexity.automation.tests;

import com.perplexity.automation.base.BaseTest;
import com.perplexity.automation.pages.HomePage;
import com.perplexity.automation.pages.LoginPage;
import com.perplexity.automation.utils.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username = ConfigReader.getInstance().getUserId();
    String password = ConfigReader.getInstance().getPassword();

    @Test
    @Description("Login to the application.")
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
        Allure.step("Login Process Started");
        loginPage.loginAs(username, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoginSuccessful(), "User is not logged in successfully!");
        Assert.assertEquals(homePage.getSuccessMessage(), "Congratulations student. You successfully logged in!");
        Allure.step("Login Process Ended");
    }
}

