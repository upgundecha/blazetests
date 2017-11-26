package com.example.test;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldLogin() throws Exception {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/login");
        driver.findElement(By.id("email")).sendKeys("user16112017@test.com");
        driver.findElement(By.id("password")).sendKeys("p@ssword");
        driver.findElement(By.className("btn")).click();

        String userNameLabelText =
                driver.findElement(By.className("dropdown-toggle")).getText();
        Assert.assertEquals("Test User", userNameLabelText);

        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
        Assert.assertTrue(driver.getPageSource().contains("You are logged in!"));

    }

    @Test
    public void shouldShowErrorWhenUserNameAndPasswordIsIncorrect() {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/login");
        driver.findElement(By.id("email")).sendKeys("user16112017@test.com");
        driver.findElement(By.id("password")).sendKeys("xyz");
        driver.findElement(By.className("btn")).click();
        Assert.assertEquals("These credentials do not match our records.",
                driver.findElement(By.className("help-block")).getText());
    }
}
