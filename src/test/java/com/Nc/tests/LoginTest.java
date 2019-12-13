package com.Nc.tests;

import com.Nc.Base.BaseClass;
import com.Nc.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        System.out.println("Title is: "+title);
        Assert.assertEquals(title, "Namaste Credit :: Login with TestAll");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        loginPage.login("admin@nc.com","super2017@");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}