package com.perplexity.automation.tests;

import com.perplexity.automation.base.BaseTest;
import com.perplexity.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoginSuccessful(), "User is not logged in successfully!");
        Assert.assertEquals(homePage.getSuccessMessage(), "Congratulations student. You successfully logged in!");
    }
}
