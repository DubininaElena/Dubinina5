package myprojects.automation.assignment5.tests;

import myprojects.automation.assignment5.BaseTest;
import myprojects.automation.assignment5.utils.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void checkSiteVersion() throws InterruptedException{
        driver.navigate().to(Properties.getBaseUrl());
        Assert.assertTrue(driver.findElement(By.cssSelector("#index")).getText().contains("ПОПУЛЯРНЫЕ ТОВАРЫ"));
        // TODO open main page and validate website version


    }
    @Parameters ({"name", "name1", "emaile", "address1", "postcode1", "city1"})
    @Test
    public void createNewOrder(String name, String name1, String emaile, String address1, String postcode1, String city1)
            throws InterruptedException {
        // TODO implement order creation test
        actions.openRandomProduct();
        actions.createOrder(name,name1,emaile);
        actions.createOrder2(address1,postcode1,city1);
        actions.verificationNumber();
        // open random product

        // save product parameters

        // add product to Cart and validate product information in the Cart

        // proceed to order creation, fill required information

        // place new order and validate order summary

        // check updated In Stock value
    }

}
