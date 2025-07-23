package com.perplexity.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility to load configuration from a .properties file, using singleton pattern.
 */
public final class ConfigReader {
    // Relative path to the config file
    private static final String CONFIG_PATH = "configs/Configuration.properties";
    private static ConfigReader instance;
    private final Properties properties = new Properties();

    // Private constructor for singleton
    private ConfigReader() {
        try (InputStream reader = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(CONFIG_PATH)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read config file at: " + CONFIG_PATH, e);
        }
    }

    // Singleton accessor
    public static ConfigReader getInstance() {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }
        return instance;
    }

    // Example getter methods for common properties
    public String getBaseUrl() {
        String url = properties.getProperty("base_url");
        if (url == null)
            throw new RuntimeException("base_url not specified in the config file.");
        return url;
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser == null)
            throw new RuntimeException("browser not specified in the config file.");
        return browser;
    }

    public int getImplicitWait() {
        String wait = properties.getProperty("implicit_wait");
        if (wait == null)
            return 10; // default
        return Integer.parseInt(wait);
    }

    public int getExplicitWait() {
        String wait = properties.getProperty("explicit_wait");
        if (wait == null)
            return 10; // default
        return Integer.parseInt(wait);
    }

    public String getUserId() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    // Generic getter for custom properties if needed
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}


