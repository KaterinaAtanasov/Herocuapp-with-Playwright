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
        BROWSER_TYPE = prop.getProperty("browser_type");
        USERNAME = prop.getProperty("username");
        PASSWORD = prop.getProperty("password");
        HEADLESS = Boolean.valueOf(prop.getProperty("headless"));
    }
}
