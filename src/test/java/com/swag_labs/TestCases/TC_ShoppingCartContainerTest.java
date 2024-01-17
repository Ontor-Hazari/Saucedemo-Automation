package com.swag_labs.TestCases;

import com.swag_labs.PageObject.Login_Model;
import com.swag_labs.PageObject.ShoppingCartContainer_Model;
import org.testng.annotations.Test;

public class TC_ShoppingCartContainerTest extends BaseClass {

    @Test
    public void VerifyProductContainerClickable() throws InterruptedException {
        ShoppingCartContainer_Model container = new ShoppingCartContainer_Model(driver);
        driver.get(url);
        Login_Model login = new Login_Model(driver);

        login.ClickLogin_Button("standard_user","secret_sauce");

        container.Contain_Product();
        Thread.sleep(2000);
    }



}
