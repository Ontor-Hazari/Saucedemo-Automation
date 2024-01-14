package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import java.util.concurrent.TimeUnit;
@Listeners(ExtentListenerClass.class)
public class TC_LoginPageTest extends BaseClass{

    @Test
      public void Verification_of_Sauce_Demo_Login_Page_Display()  {

        driver.get(url);

      }

    @Test
    public void Verify_Log_In_with_Empty_Required_Fields() {

        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);

    }

    @Test
    public void Check_User_Log_In_with_Invalid_Name() {

        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("invalid name","secret_sauce");

    }

    @Test
    public void Log_In_with_an_Invalid_Password()
    {

        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("standard_user","Invalid Pass");

    }

    @Test
    public void Log_In_with_Both_User_Name_and_Password_Invalid()  {

        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("Invalid Name","Invalid Pass");

    }


    @Test
    public void Log_In_with_Both_Email_and_Password_Valid()
    {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");



    }





}
