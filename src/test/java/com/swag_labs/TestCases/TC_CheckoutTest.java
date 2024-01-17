package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import com.swag_labs.PageObject.ShoppingCartContainer_Model;
import com.swag_labs.PageObject.checkout_Model;
import org.testng.annotations.Test;

public class TC_CheckoutTest extends BaseClass{

    @Test
    public void VerifyProductCheckoutButtonClickability() throws InterruptedException {
        driver.get(url);
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);
        Login_Model login = new Login_Model(driver);
        checkout_Model checkout = new checkout_Model(driver);

        login.ClickLogin_Button("standard_user","secret_sauce");
        container.Contain_Product();
        checkout.checkout();
        Thread.sleep(5000);
    }
}
