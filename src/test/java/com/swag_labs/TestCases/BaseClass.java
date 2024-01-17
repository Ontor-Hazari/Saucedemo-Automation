package com.swag_labs.TestCases;

import com.swag_labs.Utilities.ReadConfig;
import org.example.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {
     static Logger logger = LogManager.getLogger(BaseClass.class);
    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        try {
            initializeWebDriver();
        } catch (Exception e) {
            throw new RuntimeException("Failed to set up WebDriver: " + e.getMessage());
        }
    }

    private void initializeWebDriver() {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Open ChromeDriver");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Open FirefoxDriver");
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser specified in the config file");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            logger.info("Close Driver");
            driver.quit();
        }
    }
}
