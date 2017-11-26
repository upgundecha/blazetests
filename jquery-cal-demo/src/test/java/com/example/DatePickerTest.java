package com.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldLogin() throws Exception {

        driver = getDriver();
        driver.get("https://jqueryui.com/resources/demos/datepicker/default.html");

        driver.findElement(By.id("datepicker")).click();

        DatePicker datePicker = new DatePicker(driver);
        datePicker.setDate("01 Jan 2016");


    }
}
