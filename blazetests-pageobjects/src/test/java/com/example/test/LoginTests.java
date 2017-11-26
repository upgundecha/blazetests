package com.example.test;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.test.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldLogin() throws Exception {

        driver = getDriver();
        driver.get("http://www.blazedemo.com/login");

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage =
                loginPage.login("user16112017@test.com", "p@ssword");

        Assert.assertTrue(dashboardPage.isLoaded());
        Assert.assertEquals("Test User", dashboardPage.getUserName());

        dashboardPage.logout();

    }

    @Test
    public void shouldShowErrorWhenUserNameAndPasswordIsIncorrect() {

        driver = getDriver();
        driver.get("http://www.blazedemo.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user16112017@test.com", "euyuye");
        Assert.assertEquals("These credentials do not match our records.",
                loginPage.getMessage());
    }
}
