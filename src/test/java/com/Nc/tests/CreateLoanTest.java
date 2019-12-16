package com.Nc.tests;

import com.Nc.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateLoanTest {
   /* @FindBy(xpath="//input[@id='emailid']")
   WebElement Username;
    @FindBy(xpath="//input[@id='password']")
   WebElement password;
    @FindBy(xpath="//input[@id='signup_in']")
 WebElement signinBtn;*/

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "/home/namastecredit172/eclipse-workspace/NeoForm/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dc.loan2pal.com/login");
        driver.findElement(By.xpath("//input[@id='emailid']")).sendKeys("sushb@testnc.com");
        driver.findElement(By.xpath(("//input[@id='password']"))).sendKeys("123sush#");
        driver.findElement(By.xpath(("//input[@id='signup_in']"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@id='t-s-sign']")).click();
        driver.findElement(By.xpath("//input[@id='simple_loan_request_type_1']")).click();
        List<WebElement> loan_product_type_simple= driver.findElements(By.xpath("//input[@name='loan_product_type_simple']"));
       // System.out.println(loan_product_type_simple.get(0));
        loan_product_type_simple.get(0).click();
        List<WebElement> loan_product_type_simple_type= driver.findElements(By.xpath("//input[@name='loan_product_type_simple_type']"));
       // System.out.println(loan_product_type_simple_type.get(0));
        loan_product_type_simple_type.get(0).click();
        driver.findElement(By.xpath("//button[@class='simple-create-btn btn btn-primary']")).click();
        driver.findElement(By.xpath("//input[@id='application_ref']")).sendKeys("10101010");
        driver.findElement(By.xpath("//input[@id='annual_op_expense']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id='loan_amount']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@id='gross_revenue']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//input[@name='business_type']")).click();
        //driver.findElement(By.xpath("//input[@id='business_type']")).click();
        Select business_type=new Select (driver.findElement(By.id("business_type")));
        //List<WebElement> business_type= driver.findElements(By.xpath("//input[@id='business_type']"));
        business_type.selectByValue("1");
        driver.findElement(By.className("select2-selection__arrow")).click();
        //driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("jndajskdnjskcn");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='business_started']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id='business_gst_no']")).sendKeys("01ABCDE1234F1ZA");
        //driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("560053");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("sdfvg");
//        WebElement element = driver.findElement(By.className("btn btn-next btn-fill btn-warning btn-wd"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/input[2]")).click();
        driver.findElement(By.xpath("//input[@id='t-s-sign']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//button[@class='quick-review btn btn-danger']")).click();
        //driver.findElement(By.className("btn btn-next btn-fill btn-warning btn-wd")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/input[1]")).click();
//        //driver.findElement(By.xpath("//input[@name='next']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/input[1]")).click();
//        //driver.findElement(By.xpath("//input[@name='next']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.findElement(By.xpath("//input[@name='document-finish']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@class='quick-review btn btn-danger']")).click();










    }
}
