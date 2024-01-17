package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import com.swag_labs.PageObject.ProductPage_Model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;


public class TC_ProductPageTest extends BaseClass{


    @Test
    public void VerificationOfClickFunctionalityOnProductCard() throws InterruptedException {
        driver.get(url);
        Login_Model login = new Login_Model(driver);
        ProductPage_Model product = new ProductPage_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");
        product.Product_Add_to_cart_Click(2);

    }


    @Test(enabled = true)
    public void VerifyClickFunctionalityOnMultipleProductCards()  {
        Login_Model login = new Login_Model(driver);
        ProductPage_Model product = new ProductPage_Model(driver);

        driver.get(url);
        login.ClickLogin_Button("standard_user","secret_sauce");
        product.Product_Add_to_cart_Click(2);
        product.Product_Add_to_cart_Click(3);



    }

    @Test(enabled = true)
    public void VerifyProductTitleText()  {
        Login_Model login = new Login_Model(driver);
        ProductPage_Model product = new ProductPage_Model(driver);

        driver.get(url);
        login.ClickLogin_Button("standard_user","secret_sauce");
       String p_name = product.Product_Title(2);

       System.out.println(p_name);

       //implement screenshort method

        Assert.fail();



    }


    @Test(enabled = true)
    public void VerifyProductDescriptionText()  {
        Login_Model login = new Login_Model(driver);
        ProductPage_Model product = new ProductPage_Model(driver);

        driver.get(url);
        login.ClickLogin_Button("standard_user","secret_sauce");
       product.Product_Decription_View(2);







    }




}
