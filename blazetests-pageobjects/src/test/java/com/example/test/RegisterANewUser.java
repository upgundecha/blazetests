package com.example.test;

import com.example.pages.DashboardPage;
import com.example.pages.RegisterPage;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegisterANewUser extends BaseTest {

    WebDriver driver;
    Faker faker;

    @Test
    public void shouldRegisterAUser() {

        driver = getDriver();

        faker = new Faker();
        String name = faker.name().fullName();
        String company = faker.company().name();
        String email = faker.internet().emailAddress();

        driver.get("http://www.blazedemo.com/register");

        RegisterPage registerPage = new RegisterPage(driver);
        DashboardPage dashboardPage =
                registerPage.registerUser(name, company, email, "p@ssword");

        Assert.assertTrue(dashboardPage.isLoaded());
        Assert.assertEquals(name, dashboardPage.getUserName());
    }
}
