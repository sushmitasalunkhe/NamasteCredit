package com.Nc.tests;

import com.Nc.Base.BaseClass;
import com.Nc.Data.LoginData;
import com.Nc.Pages.LoginPage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTest extends LoginData {

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

   /* @Test(priority = 3, dataProvider ="validCredentials")
    public void loginTestValid( String Email, String Password) {

        loginPage.validlogin(Email,Password);
    }*/
   @Test(priority = 3, dataProvider ="LoginPositive")
    public void loginTestValid(String Testid, String Usertype, String Email, String Password) {
        DataSet++;
        System.out.println("Test id running is: "+Testid);
        System.out.println("UserType is: "+Usertype);
        System.out.println("email id is: "+Email);
       System.out.println("password is: "+Password);
        loginPage.validlogin(Email,Password);
    }
    @Test(priority = 4, dataProvider ="LoginNegative")
    public void loginTestInvalid(String Testid, String Email, String Password, String ExpectedErrorMsg) {
        DataSet++;
        System.out.println("Test id running is: "+Testid);
        System.out.println("email id is: "+Email);
        System.out.println("password is: "+Password);
        loginPage.Invalidlogin(Email,Password,ExpectedErrorMsg);
    }

   /* @Test(priority = 4, dataProvider ="invalidCredentials")
    public void loginTestInvalid(String un,String pwd) {
        loginPage.Invalidlogin(un,pwd);
    }*/

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}