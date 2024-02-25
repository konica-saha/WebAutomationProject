package testcases;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;
import uitilities.DriverSetup;

public class TestCheckOut extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test(description = " User purchase Product")
    @Severity(SeverityLevel.NORMAL)
    public void purchaseProduct(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.addProductToCart(productPage.bikeLight);
        productPage.clickOnElement(productPage.shoppingCart);
        checkOutPage.clickOnElement(checkOutPage.checkOut);
        checkOutPage.writeOnAElement(checkOutPage.firstNameField, "Jhon");
        checkOutPage.writeOnAElement(checkOutPage.lastNameField, "Right");
        checkOutPage.writeOnAElement(checkOutPage.postalCode, "2315");
        checkOutPage.clickOnElement(checkOutPage.continueButton);
        checkOutPage.clickOnElement(checkOutPage.finishButton);
        Assert.assertEquals(checkOutPage.getElementText(checkOutPage.greetingsText), "Thank you for your order!");
        checkOutPage.takeScreenShot("After Purchase Product");
    }
}
