package com.OrangeHRM.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = PropertiesHelper.class
                .getClassLoader()
                .getResourceAsStream("config/config.properties")) {

            if (input == null) {
                throw new RuntimeException("Cannot find config.properties file");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing config key: " + key);
        }
        return value.trim();
    }

    public static String getValue(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue).trim();
    }

    public static int getIntValue(String key) {
        try {
            return Integer.parseInt(getValue(key));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid integer value for key: " + key);
        }
    }

    public static boolean getBooleanValue(String key) {
        return Boolean.parseBoolean(getValue(key));
    }
}