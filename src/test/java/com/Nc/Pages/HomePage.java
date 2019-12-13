package com.Nc.Pages;

import com.Nc.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {


    //Initializing the Page Objects:
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:



}
