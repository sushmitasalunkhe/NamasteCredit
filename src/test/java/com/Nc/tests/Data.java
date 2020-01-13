package com.Nc.tests;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Data {
    public static WebDriver driver;
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location ="/home/namastecredit172/Documents/Login" +
            ".xls";
    static String SheetName= "positive";
    public  String Res;
    //Write obj1=new Write();
    public int DataSet=-1;
  /*  @BeforeSuite
    public void OpenBrowser() throws InterruptedException

    {
        System.setProperty("webdriver.gecko.driver", "/home/namastecredit172/NamasteCredit/Drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.91/user/login");
        Thread.sleep(3000);
    }*/

    @DataProvider
    public static Object[][] ReadVariant() throws IOException
    {
        FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned her
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0); //get my Row which start from 0  

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
        for(int i=0; i<RowNum-1; i++) //Loop work for Row
             {
                HSSFRow row= worksheet.getRow(i+1);

                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if (row == null)
                    Data[i][j] = "";
                    else {
                        HSSFCell cell = row.getCell(j);
                            if (cell == null)
                                Data[i][j] = ""; //if it get Null value it pass no data
                            else {
                                 String value = formatter.formatCellValue(cell);
                                 Data[i][j] = value; //This formatter get my all values as string i.e integer, float all type data value
                                 }
                        }
                }
             }
        return Data;
    }
@Test //Test method
(dataProvider="ReadVariant") //It get values from ReadVariant function method

//Here my all parameters from excel sheet are mentioned.
public void AddVariants(String Testid, String Usertype, String Email, String Password, String TestResult) throws Exception
{
    //Data will set in Excel sheet once one parameter will get from excel sheet to Respective locator position.
DataSet++;
System.out.println("Testid is:" +Testid);
System.out.println("Usertype is:" +Usertype);
System.out.println("Email is:" +Email);
System.out.println("Password is:" +Password);
System.out.println("TestResult is: " +TestResult);
}


}


