package com.swag_labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout_Model {

    WebDriver driver;
    public checkout_Model(WebDriver driver)
    {this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //Header
    //Weelement checkout

    @FindBy(id = "checkout")
    public WebElement checkout;


    public void checkout()
    {
        checkout.click();
    }


}
