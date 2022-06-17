package config;

import base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    InputStream inputStream = null;

    private void readProperty() throws IOException {

        inputStream = new FileInputStream("src/main/java/config/GlobalConfig.properties");
        Properties properties = new Properties();

        properties.load(inputStream);


        Settings.userName = properties.getProperty("userName");
        Settings.password = properties.getProperty("password");
        Settings.testUrl = properties.getProperty("testUrl");
        Settings.browserType= BrowserType.valueOf(properties.getProperty("browserType"));


    }


    public static void populateSettings() throws IOException {
        ConfigReader configReader=new ConfigReader();
        configReader.readProperty();


    }
}
