package com.Nc.tests;

import com.Nc.Base.BaseClass;
import com.Nc.Pages.LoginPage;
import com.Nc.Pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogoutTest extends BaseClass {
    LoginPage loginPage;
    LogoutPage logoutPage;
    public LogoutTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        logoutPage = loginPage.login("SushLender@testnc.com","123sush#");
    }

    @Test(priority = 1)
    public void LogoutTest() {
        logoutPage.logout();
        String ActCurrentUrl=driver.getCurrentUrl();
        System.out.println(ActCurrentUrl);
        Assert.assertEquals(ActCurrentUrl,"http://dc.loan2pal.com/login");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
