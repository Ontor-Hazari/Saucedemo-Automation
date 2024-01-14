package com.swag_labs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage_Model {
    WebDriver driver;

    public ProductPage_Model(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Header
//    WebElement addItem;

    @FindBy(id ="add-to-cart-sauce-labs-backpack")
    WebElement addtocart;

    @FindBy(id ="//div[@class=\"inventory_item\"]["+1+"]/div[2]/div[2]/button")
    WebElement Array_Add_To_Cart;

    @FindBy(xpath ="//div[@class=\"inventory_item\"]"  )
    WebElement Add_To_Cart_Button;


    //List<WebElement> Iteam_Click =  driver.findElements(By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])"));


    public void Product_Add_to_cart_Click(int num)
    {


        List<WebElement> Iteam_Click =  driver.findElements(By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])"));

        Iteam_Click.get(num-1).click();


    }

    public String Product_Add_to_cart_Text(int num)
    {


        List<WebElement> Iteam_Click =  driver.findElements(By.xpath("(//button[@class=\"btn btn_secondary btn_small btn_inventory \"])"));

        return Iteam_Click.get(num-1).getText();

    }



    public void Product_Decription_View(int num)
    {

        List<WebElement> Iteam_List =  driver.findElements(By.xpath("(//div[@class=\"inventory_item_name \"])"));

        Iteam_List.get(num-1).click();



    }

    public String Product_Title(int num)
    {

        List<WebElement> Iteam_List =  driver.findElements(By.xpath("(//div[@class=\"inventory_item_name \"])"));

        return Iteam_List.get(num-1).getText();




    }


    public void Click_add_to_cart()
    {
        addtocart.click();
    }

}
