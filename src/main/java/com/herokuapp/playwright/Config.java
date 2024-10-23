package com.herokuapp.playwright;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String BASE_URL;
    public static final String BROWSER_TYPE;
    public static final String USERNAME;
    public static final String PASSWORD;
    public static final Boolean HEADLESS;
    public static final String INVALID_USERNAME;
    public static final String INVALID_PASSWORD;


    static {
        Properties prop = new Properties();
        InputStream ip = ClassLoader.getSystemResourceAsStream("config.properties");

        try {
            if (ip != null) {
                prop.load(ip);
            } else {
                throw new FileNotFoundException("Could not find the 'config.properties' file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE_URL = prop.getProperty("base_url");
        BROWSER_TYPE = System.getProperty("browser_type", prop.getProperty("browser_type"));
        USERNAME = prop.getProperty("username");
        PASSWORD = prop.getProperty("password");
        HEADLESS = Boolean.valueOf(System.getProperty("headless", prop.getProperty("headless")));
        INVALID_USERNAME = prop.getProperty("invalid_username");
        INVALID_PASSWORD = prop.getProperty("invalid_password");
    }
}
