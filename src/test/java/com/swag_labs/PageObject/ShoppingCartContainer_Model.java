package com.swag_labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartContainer_Model {


    WebDriver driver;
    public ShoppingCartContainer_Model(WebDriver driver)
    {this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cart;

    public void Contain_Product() {
        cart.click();

    }

}
