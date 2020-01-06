package com.Nc.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    // Constant for Database Password
    public static void initialization() {
        System.setProperty("webdriver.gecko.driver", "/home/namastecredit172/Downloads/NamasteCredit/Drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dc.loan2pal.com/login");

    }

    public static int getOtp() throws Exception {
        Connection con = null;
        Statement stmt;
        String DB_URL = "jdbc:mysql://ncbiztestenv.chaqiqb07wh0.ap-southeast-1.rds.amazonaws.com:3306/ncbusiness";
        String DB_USER = "testadmin1";
        String DB_PASSWORD = "testadmin123";
        String dbClass = "com.mysql.jdbc.Driver";
        Class.forName(dbClass).newInstance();
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        stmt = con.createStatement();

            String query = "select otp from user_otp order by id desc";

            // Get the contents of userinfo table from DB

            ResultSet res = stmt.executeQuery(query);

            // Print the result untill all the records are printed

            // res.next() returns true if there is any next record else returns false

        List<String > otps=new ArrayList<String>();
        while (res.next())

        {

            String otp=res.getString(1);
            otps.add(otp);

        }
        System.out.println(otps.get(0));
        int Otp=Integer.parseInt(otps.get(0));
        return Otp;



    }
}
