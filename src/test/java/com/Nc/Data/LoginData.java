package com.Nc.Data;

import com.Nc.Base.BaseClass;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginData extends BaseClass   {
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location ="/home/namastecredit172/Documents/Login" +
            ".xls";
    static String SheetName= "positive";

    public  String Res;
    //Write obj1=new Write();
    public int DataSet=-1;
    @DataProvider
    public static Object[][] ReadVariant() throws IOException
    {
        FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned her
        workbook = new HSSFWorkbook(fileInputStream); //get my workbook
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
}
