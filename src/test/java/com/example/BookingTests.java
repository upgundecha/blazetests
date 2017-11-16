package com.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class BookingTests extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldDisplayFlightChoices() {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/");

        WebElement fromPort = driver.findElement(By.name("fromPort"));
        WebElement toPort = driver.findElement(By.name("toPort"));

        Select fromPortDropdown = new Select(fromPort);
        Select toPortDropdown = new Select(toPort);

        fromPortDropdown.selectByVisibleText("Boston");
        toPortDropdown.selectByVisibleText("London");

        driver.findElement(By.className("btn-primary")).click();

        List<WebElement> flightOptions =
                driver.findElements(By.xpath("//table/tbody/tr"));

        Assert.assertEquals(6, flightOptions.size());
    }

    @Test
    public void shouldDisplayFlightDetails() {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/");

        WebElement fromPort = driver.findElement(By.name("fromPort"));
        WebElement toPort = driver.findElement(By.name("toPort"));

        Select fromPortDropdown = new Select(fromPort);
        Select toPortDropdown = new Select(toPort);

        fromPortDropdown.selectByVisibleText("Boston");
        toPortDropdown.selectByVisibleText("London");

        driver.findElement(By.className("btn-primary")).click();

        List<WebElement> flightOptions =
                driver.findElements(By.xpath("//table/tbody/tr"));

        Assert.assertEquals(5, flightOptions.size());

        driver.findElement(By.xpath("//td[text()='234']/parent::tr//input[@value='Choose This Flight']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Airline: United Airlines"));
        Assert.assertTrue(driver.getPageSource().contains("Flight Number: 234"));
    }
}

