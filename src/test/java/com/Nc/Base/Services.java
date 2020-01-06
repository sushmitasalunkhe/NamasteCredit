package com.Nc.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.log4j.Logger.getLogger;

public class Services {
    private static Logger logger = getLogger(Services.class.getName());
    protected WebDriver driver;

    public Services(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated((By)locator));
    }

}
