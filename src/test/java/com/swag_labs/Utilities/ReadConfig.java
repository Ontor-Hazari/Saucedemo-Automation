package com.swag_labs.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
 Properties properties;

    String path = "E:\\Selenium\\Real_Life_Project\\Configuration\\config.properties";

    public ReadConfig() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBaseUrl() {

        String value = properties.getProperty("baseUrl");
        if(value != null)
        {
            return  value;
        }
        else {
                     throw new RuntimeException("Url Not Found");
        }
    }

    public String getBrowser() {

        String value = properties.getProperty("browser");
        if(value != null)
        {
            return  value;
        }
        else {
            throw new RuntimeException("browser Not Found");
        }
    }

}
