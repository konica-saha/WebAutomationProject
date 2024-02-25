package testcases;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import uitilities.DriverSetup;

public class TestProductPage extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    @Test(description = "Checking the Product Details")
    @Severity(SeverityLevel.NORMAL)
    public void testProductDetails(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.bikeLight);
        Assert.assertEquals(productPage.getElementText(productPage.productTitle), "Sauce Labs Bike Light");
        productPage.takeScreenShot("After Product Details");
    }

    @Test(description = "Checking the Add to cart")
    @Severity(SeverityLevel.NORMAL)
    public void testAddCart(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.bikeLight);
        productPage.clickOnElement(productPage.addToChatButton);
        Assert.assertTrue(productPage.getElement(productPage.removeButton).isDisplayed());
        Assert.assertEquals(productPage.getElementText(productPage.cartCount), "1");
        productPage.takeScreenShot("After Add to cart");
    }

}
