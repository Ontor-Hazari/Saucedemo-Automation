package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TC_LoginPageTest extends BaseClass {



    @Test
    public void displayLoginPage() {
        driver.get(url);
        logger.info("The login page is open, and execution starts.");
        // Additional verification/assertions can be added here
    }

    @Test
    public void loginWithEmptyFields() {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("", "");
        // Additional verification/assertions can be added here
    }

    @Test
    public void loginWithInvalidUsername() {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("invalid name", "secret_sauce");
        // Additional verification/assertions can be added here
    }

    @Test
    public void loginWithInvalidPassword() {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("standard_user", "Invalid Pass");
        // Additional verification/assertions can be added here
    }

    @Test
    public void loginWithInvalidCredentials() {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("Invalid Name", "Invalid Pass");
        // Additional verification/assertions can be added here
    }

    @Test
    public void loginWithValidCredentials() {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("standard_user", "secret_sauce");
        logger.info("The login page is open, and execution starts.");
        // Additional verification/assertions can be added here
        logger.info("The login page execution Stop.");
    }
}
