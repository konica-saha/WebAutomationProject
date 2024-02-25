package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.SignInPage;
import uitilities.DataSet;
import uitilities.DriverSetup;

public class TestLogin extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(description = "Test Login with valid user credentials")
    @Description("User trying to login with valid username and password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithValidCredentials(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.takeScreenShot("After enter username");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.takeScreenShot("After enter password");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
        loginPage.takeScreenShot("After login successful");
    }

    @Test(description = "Test Login With Invalid Password")
    @Description("User trying to login with valid username and Invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidPassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
        loginPage.takeScreenShot("Click Login Button");
    }



    @Test(description = "Test Loginin With Invalid Username")
    @Description("User trying to login with Invalid username and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidUsername(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
        loginPage.takeScreenShot("Click Login Button");
    }

    @Test(description = "Test Login With Invalid Username & Password")
    @Description("User trying to login with Invalid username and Invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidUsernamePassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_s");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
        loginPage.takeScreenShot("Click Login Button");
    }

    @Test(description = "Test Login Without Password")
    @Description("User trying to login with valid username and empty password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithoutPassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Password is required");
        loginPage.takeScreenShot("Click Login Button");
    }

    @Test(description = "Test Login Without Username")
    @Description("User trying to login with empty username and valid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithoutUsername(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username is required");
        loginPage.takeScreenShot("Click Login Button");
    }

    @Test(description = "Test Login Without Username & Password")
    @Description("User trying to login with Without username and password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithoutUsernamePassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username is required");
        loginPage.takeScreenShot("Click Login Button");
    }


    @Test(dataProvider = "invalidUserData", dataProviderClass = DataSet.class)
    @Description("User trying to login with Invalid username and Invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithInvalidCredentials(String username, String password, String errorMsg){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, username);
        loginPage.writeOnAElement(loginPage.passwordInputBox, password);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), errorMsg);
        loginPage.takeScreenShot("Click Login Button");
    }


}
