package com.perplexity.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver(String browser, String runMode, String gridUrl) {
        if (driver.get() == null) {
            WebDriver webDriver = null;
            browser = browser.toLowerCase();
            runMode = runMode.toLowerCase();

            try {
                switch (browser) {
                    case "chrome":
                        if ("remote".equals(runMode)) {
                            ChromeOptions chromeOptions = new ChromeOptions();
                            webDriver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                        } else {
                            // Selenium Manager (Selenium 4.6+) sets up the driver binary itself
                            webDriver = new ChromeDriver();
                        }
                        break;
                    case "firefox":
                        if ("remote".equals(runMode)) {
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                            webDriver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                        } else {
                            webDriver = new FirefoxDriver();
                        }
                        break;
                    case "edge":
                        if ("remote".equals(runMode)) {
                            EdgeOptions edgeOptions = new EdgeOptions();
                            webDriver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                        } else {
                            webDriver = new EdgeDriver();
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Browser not supported: " + browser);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
            }

            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver.get())) {
            driver.get().quit();
            driver.remove();
        }
    }
}
