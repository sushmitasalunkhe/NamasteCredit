package com.Nc.Pages;

import com.Nc.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//input[@id='emailid']")
    WebElement Username;
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//input[@id='signup_in']")
    WebElement signinBtn;
    @FindBy(xpath="//img[@class='logo_position']")
    WebElement Logo;
    //Initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
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

        return new LogoutPage();
    }



}

