package com.Nc.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTesingDemo {
    // Connection object

    static Connection con = null;

        // Statement object

    private static Statement stmt;

        // Constant for Database URL
   // public static String DB_URL="jdbc:mysql://18.136.14.70:3306/ncbusinees.user_otp";
    public static String DB_URL = "jdbc:mysql://ncbiztestenv.chaqiqb07wh0.ap-southeast-1.rds.amazonaws.com:3306/ncbusiness";

        // Constant for Database Username

    public static String DB_USER = "testadmin1";

        // Constant for Database Password

    public static String DB_PASSWORD = "testadmin123";



    @BeforeMethod

    public void setUp() throws Exception {

        try{

            // Make the database connection

            String dbClass = "com.mysql.jdbc.Driver";

            Class.forName(dbClass).newInstance();

            // Get connection to DB

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Statement object to send the SQL statement to the Database

            stmt = con.createStatement();

        }

                     catch (Exception e)

        {

            e.printStackTrace();

        }

    }



    @Test

    public void test() {

        try{

            String query = "select otp from user_otp order by id desc";

            // Get the contents of userinfo table from DB

            ResultSet res = stmt.executeQuery(query);
           // System.out.println(res);
            // Print the result untill all the records are printed

            // res.next() returns true if there is any next record else returns false
            List<String >otps=new ArrayList<String>();
            while (res.next())

            {

               String otp=res.getString(1);
               otps.add(otp);

            }
            System.out.println(otps.get(0));

        }
        catch(Exception e)

        {

            e.printStackTrace();

        }

    }



    @AfterMethod

    public void tearDown() throws Exception {

        // Close DB connection

        if (con != null) {

            con.close();

        }

    }
    //testadmin1@ncbiztestenv.chaqiqb07wh0.ap-southeast-1.rds.amazonaws.com:3306
    //ncbiztestenv.chaqiqb07wh0.ap-southeast-1.rds.amazonaws.com
}
