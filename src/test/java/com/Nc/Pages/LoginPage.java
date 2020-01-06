package com.Nc.Pages;

import com.Nc.Base.BaseClass;

import com.Nc.Base.Services;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Services {

    @FindBy(xpath="//input[@id='emailid']")
    WebElement Username;
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//input[@id='signup_in']")
    WebElement signinBtn;
    @FindBy(xpath="//img[@class='logo_position']")
    WebElement Logo;
    @FindBy(xpath = "//h1[@class='page-header17']")
    WebElement header;

    @FindBy(xpath="//input[@id='remember_me']")
    WebElement remember_me;
    @FindBy(xpath = "//a[contains(text(),'Resend Activation?')]")
    WebElement Resend_Activation;
    @FindBy (xpath = "//a[@id='forgot_pwd']")
    WebElement forgot_password;
    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    WebElement register_button;

    private String Title="/html/head/title";


    //Initializing the Page Objects:
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //Actions:
    public String validateLoginPageTitle(){
       //waitForElement(Title);got
       //waitForElement(Title);
        return driver.getTitle();
    }

    public boolean validateImage(){
        return Logo.isDisplayed();
    }


    public LogoutPage login(String un, String pwd){

        Username.sendKeys(un);
        password.sendKeys(pwd);
        signinBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForElement(Username);


        return new LogoutPage();
    }



}

