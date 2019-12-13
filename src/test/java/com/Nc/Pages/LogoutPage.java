package com.Nc.Pages;

import com.Nc.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {
    @FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")
    WebElement profile;
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement Logout;
    //Initializing the Page Objects:
    public LogoutPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:




    public void logout(){

        profile.click();
        Logout.click();




    }

}
