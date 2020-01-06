package com.Nc.Pages;

import com.Nc.Base.BaseClass;

//import com.Nc.Base.Services;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//input[@id='emailid']")
    WebElement Username;
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//input[@id='signup_in']")
    WebElement signinBtn;
    NoSuchElementException ignored;
    @FindBy(xpath = "//div[@class='form-group error']//div[@class='error'][contains(text(),'The Email field must contain a valid email address')]")
    WebElement ErrorMsgforEmail;

    @FindBy(xpath = "//div[@class='error']")
    WebElement ErrorForWrongPwd;
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
    String ExpectedUrl="http://dc.loan2pal.com/dashboard";
    String ExpectedErrorMsgforEmail="The Email field must contain a valid email address.";
    String ExpectedErrorforWrongPwd="Invalid user Credientials!";


    //Initializing the Page Objects:
    public LoginPage(WebDriver driver) {
       // super(driver);
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


    public LogoutPage validlogin(String un, String pwd){
        Username.isDisplayed();
        Username.sendKeys(un);
        password.sendKeys(pwd);
        signinBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ActualUrl=driver.getCurrentUrl();

        AssertJUnit.assertEquals(ActualUrl,ExpectedUrl);
      //  waitForElement(Username);
        return new LogoutPage();
    }
    public LogoutPage Invalidlogin(String un, String pwd){
        Username.isDisplayed();
        Username.sendKeys(un);
        password.sendKeys(pwd);
        signinBtn.click();

        if (ElementPresent(ErrorMsgforEmail)){
            String ActualErrorMsgforEmail=ErrorMsgforEmail.getText();
            AssertJUnit.assertEquals(ActualErrorMsgforEmail,ExpectedErrorMsgforEmail);

        }
        else if(ElementPresent(ErrorForWrongPwd)){
            String ActualErrorforWrongPwd=ErrorForWrongPwd.getText();
            AssertJUnit.assertEquals(ActualErrorforWrongPwd,ExpectedErrorforWrongPwd);
        }
        AssertJUnit.assertNotSame(ExpectedUrl,driver.getCurrentUrl());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  waitForElement(Username);


        return new LogoutPage();
    }



}

