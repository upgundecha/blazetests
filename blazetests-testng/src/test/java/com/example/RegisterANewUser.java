package com.example;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
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

        driver.findElement(By.id("name"))
                .sendKeys(name);

        driver.findElement(By.id("company"))
                .sendKeys(company);

        driver.findElement(By.id("email"))
                .sendKeys(email);

        driver.findElement(By.id("password"))
                .sendKeys("p@assword");

        driver.findElement(By.id("password-confirm"))
                .sendKeys("p@assword");

        driver.findElement(By.className("btn")).click();

        String userNameLabelText =
                driver.findElement(By.className("dropdown-toggle")).getText();

        Assert.assertEquals(name, userNameLabelText);
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
        Assert.assertTrue(driver.getPageSource().contains("You are logged in!"));
    }
}
