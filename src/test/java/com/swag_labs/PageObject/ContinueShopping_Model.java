package com.swag_labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContinueShopping_Model {
    //Class No 5
    WebDriver driver;
    public ContinueShopping_Model(WebDriver driver)
    {this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //Header
    //Webelement
    @FindBy(id = "first-name")
    WebElement firstname;

    @FindBy(id = "last-name")
    WebElement lastname;

    @FindBy(id = "postal-code")
    WebElement postalcode;

    @FindBy(id = "continue")
    WebElement continuebutton;


    public void continuebutton(String first_Name, String last_Name, String code) {
        firstname.sendKeys(first_Name);
        lastname.sendKeys(last_Name);
        postalcode.sendKeys(code);
        continuebutton.click();

    }
}
