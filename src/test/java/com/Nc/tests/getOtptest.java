package com.Nc.tests;

import com.Nc.Base.BaseClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class getOtptest extends BaseClass {
    @Test
    public void getOtpTest() throws Exception {
        System.out.println(getOtp());
    }
}
