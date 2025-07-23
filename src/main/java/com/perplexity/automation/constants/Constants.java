package com.perplexity.automation.constants;


public final class Constants {

    public static final String BASE_URL = "https://example.com";
    public static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/screenshots/";
    public static final String REPORTS_DIR = System.getProperty("user.dir") + "/reports/";
    public static final int DEFAULT_WAIT_SECONDS = 10;
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";

    private Constants() {
    } // Prevent instantiation
}

