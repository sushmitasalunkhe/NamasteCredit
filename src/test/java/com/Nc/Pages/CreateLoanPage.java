package com.Nc.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateLoanPage {

    @FindBy(xpath="//a[@id='t-s-sign']")
    WebElement IciciLoanBtn;

    @FindBy(xpath="//input[@id='simple_loan_request_type_1']")//business
    WebElement loan_request_type;
    @FindBy(xpath="//input[@class='loan_product_type_simple']")
    List<WebElement> loan_product_type_simple;
    @FindBy(xpath="//input[@class='loan_product_type_simple_type']")
    List<WebElement> loan_product_type_simple_type;

    @FindBy(xpath="//button[@class='simple-create-btn btn btn-primary']")
    WebElement CreateBtn;
    @FindBy(xpath="//input[@id='application_ref']")
    WebElement application_ref;
    @FindBy(xpath="//input[@id='annual_op_expense']")
    WebElement annual_op_expense;
    @FindBy(xpath="//input[@id='loan_amount']")
    WebElement loan_amount;
    @FindBy(xpath="//input[@id='gross_revenue']")
    WebElement gross_revenue;
    @FindBy(xpath="//input[@name='next']")
    WebElement next1;
    @FindBy(xpath="//select[@id='business_type']")
    WebElement business_typeBox;
    @FindBy(xpath="//input[@name='business_type']")
    List<WebElement> business_types;
    @FindBy(xpath="//span[@id='select2-business_name-container']\"")
    WebElement business_name;
    @FindBy(xpath="//input[@id='business_started']")
    WebElement business_started;
    @FindBy(xpath="//input[@id='business_gst_no']")
    WebElement business_gst_no;
    @FindBy(xpath="//input[@name='next']")
    WebElement next2;
    @FindBy(xpath="//input[@id='pincode']")
    WebElement pincode;
    @FindBy(xpath="//input[@id='address1']")
    WebElement address1;
    @FindBy(xpath="//input[@name='next']")
    WebElement contactpage_next;
    @FindBy(xpath="//input[@name='next']")
    WebElement kyc_next;
    @FindBy(xpath="//input[@name='next']")
    WebElement finance_next;
    @FindBy(xpath="//input[@id='document-finish']")
    WebElement document_next;
    @FindBy(xpath="//button[@class='quick-review btn btn-danger']")
    WebElement quick_review_btn;
public void createLoanTest(){
    IciciLoanBtn.click();
    loan_request_type.click();
    loan_product_type_simple.get(0).click();
    loan_product_type_simple_type.get(0).click();
    CreateBtn.click();
    application_ref.sendKeys("10111011");




}
}
