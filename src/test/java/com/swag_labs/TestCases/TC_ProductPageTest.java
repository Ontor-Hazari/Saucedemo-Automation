package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import com.swag_labs.PageObject.ProductPage_Model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
@Listeners(ExtentListenerClass.class)
public class TC_ProductPageTest extends BaseClass{


    @Test
    public void Verification_of_Sauce_Demo_Login_Page_Display()  {
        Login_Model login = new Login_Model(driver);
        ProductPage_Model product = new ProductPage_Model(driver);

        driver.get(url);
        login.ClickLogin_Button("standard_user","secret_sauce");
        product.Product_Add_to_cart_Click(2);


    }

}
