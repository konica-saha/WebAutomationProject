package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{


//    public String emailErrorText = "Please enter a valid email address.";
    public By emailField =  By.xpath("//input[@id='iptLgnPlnID']");
    public By passwordField =  By.xpath("//input[@id='iptLgnPlnPD']");
    public By rememberMe =  By.xpath("//label[normalize-space()='Remember Me']");
    public By loginButton =  By.xpath("//button[normalize-space()='Login']");
    public By resetPassword =  By.xpath("//a[normalize-space()='Reset password']");
    public By createAccount =  By.xpath("//a[normalize-space()='Create Account/Sign Up']");
}
