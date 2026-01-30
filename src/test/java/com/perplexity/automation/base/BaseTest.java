package com.perplexity.automation.base;

import com.perplexity.automation.utils.ConfigReader;
import com.perplexity.automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "runMode", "gridUrl"})
    public void setUp(@Optional("firefox") String browser,
                      @Optional("local") String runMode,
                      @Optional("http://localhost:4444/") String gridUrl) {

        DriverFactory.initDriver(browser, runMode, gridUrl);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        // Load base URL from config or override in your testng.xml
        String baseUrl = ConfigReader.getInstance().getBaseUrl();
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

