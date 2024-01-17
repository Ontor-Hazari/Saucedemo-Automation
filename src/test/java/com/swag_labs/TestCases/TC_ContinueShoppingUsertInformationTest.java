package com.swag_labs.TestCases;

import com.swag_labs.PageObject.ContinueShopping_Model;
import com.swag_labs.PageObject.Login_Model;
import com.swag_labs.PageObject.ShoppingCartContainer_Model;
import com.swag_labs.PageObject.checkout_Model;
import org.testng.annotations.Test;

public class TC_ContinueShoppingUsertInformationTest extends BaseClass{
    // Class 05

    @Test
     public void VerifyWithoutFillupFirstnameContinue()
     {

         driver.get(url);
         Login_Model login = new Login_Model(driver); //log in
         ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);//product page
         checkout_Model checkout = new checkout_Model(driver); // checkout
         ContinueShopping_Model client = new ContinueShopping_Model(driver);
         login.ClickLogin_Button("standard_user","secret_sauce");
         container.Contain_Product();
         checkout.checkout();
         client.continuebutton("","Hazari","2010");

     }

    @Test
    public void VerifyWithoutFillupLastnameContinue()
    {
        driver.get(url);
        Login_Model login = new Login_Model(driver); //log in
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);//product page
        checkout_Model checkout = new checkout_Model(driver); // checkout
        ContinueShopping_Model client = new ContinueShopping_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");
        container.Contain_Product();
        checkout.checkout();
        client.continuebutton("Ontor","","2010");

    }
    @Test
    public void VerifyWithoutFillupZipeCodeContinue()
    {
        driver.get(url);
        Login_Model login = new Login_Model(driver); //log in
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);//product page
        checkout_Model checkout = new checkout_Model(driver); // checkout
        ContinueShopping_Model client = new ContinueShopping_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");
        container.Contain_Product();
        checkout.checkout();
        client.continuebutton("Ontor","Hazari","");
    }
    @Test
    public void VerifyWithoutFillupAllFiledContinue()
    {
        driver.get(url);
        Login_Model login = new Login_Model(driver); //log in
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);//product page
        checkout_Model checkout = new checkout_Model(driver); // checkout
        ContinueShopping_Model client = new ContinueShopping_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");
        container.Contain_Product();
        checkout.checkout();
        client.continuebutton("","","");
    }
    @Test
    public void VerifyFillupAllFiledContinue()
    {
        driver.get(url);
        Login_Model login = new Login_Model(driver); //log in
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);//product page
        checkout_Model checkout = new checkout_Model(driver); // checkout
        ContinueShopping_Model client = new ContinueShopping_Model(driver);
        login.ClickLogin_Button("standard_user","secret_sauce");
        container.Contain_Product();
        checkout.checkout();
        client.continuebutton("Ontor","Hazari","2010");
    }


}
