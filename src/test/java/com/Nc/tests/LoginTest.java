package com.Nc.tests;

import com.Nc.Base.BaseClass;
import com.Nc.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    LoginPage loginPage;
    @DataProvider
    public static Object[][] validCredentials() { return new Object[][]{{"admin@nc.com", "super2017@"}}; }

    @DataProvider
    public static Object[][] invalidCredentials() {
        return new Object[][]{{"admin@nc.com", "SUPER2017@"}};
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
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

    @Test(priority = 3, dataProvider ="validCredentials")
    public void loginTestValid(String un,String pwd) {
        loginPage.validlogin(un,pwd);
    }
    @Test(priority = 4, dataProvider ="invalidCredentials")
    public void loginTestInvalid(String un,String pwd) {
        loginPage.Invalidlogin(un,pwd);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}