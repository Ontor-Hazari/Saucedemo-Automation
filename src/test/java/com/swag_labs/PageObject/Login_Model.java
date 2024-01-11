package com.swag_labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Model {

    WebDriver driver;

    public Login_Model(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }


    @FindBy(id="user-name")
    WebElement userName;

    @FindBy(id="password")
    WebElement userPassword;

    @FindBy(id="login-button")
    WebElement userLogin;



    public  void ClickLogin_Button(String name,String pass)
    {
        userName.clear();
        userName.sendKeys(name);

        userPassword.clear();
        userPassword.sendKeys(pass);

        userLogin.click();
    }





}
