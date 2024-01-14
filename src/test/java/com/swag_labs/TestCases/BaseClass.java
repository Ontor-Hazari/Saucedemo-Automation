package com.swag_labs.TestCases;

import com.swag_labs.Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.SocketException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {


    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        int maxRetries = 3;
        int retryCount = 0;
        boolean setupComplete = false;

        while (retryCount < maxRetries && !setupComplete) {
            try {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    default:
                        System.out.println("Unsupported browser specified in the config file");
                }

                Thread.sleep(2000);
                // Set up complete if no exception occurred
                setupComplete = true;
            } catch (Exception e) {
                System.out.println("Exception during WebDriver setup. Retrying...");
                retryCount++;
            }
        }

        if (!setupComplete) {
            throw new RuntimeException("Failed to set up WebDriver after " + maxRetries + " retries.");
        }
    }

@AfterClass
public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
    driver.quit();
}



}
