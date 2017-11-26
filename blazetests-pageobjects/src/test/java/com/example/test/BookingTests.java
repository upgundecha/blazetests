package com.example.test;

import com.example.pages.FlightOptionsPage;
import com.example.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldDisplayFlightChoices() {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/");

        HomePage homePage = new HomePage(driver);
        FlightOptionsPage flightOptionsPage =
                homePage.findFlights("Boston", "London");
        Assert.assertEquals(5, flightOptionsPage.getOptionsCount());
    }

    @Test
    public void shouldDisplayFlightDetails() {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/");

        HomePage homePage = new HomePage(driver);
        FlightOptionsPage flightOptionsPage =
                homePage.findFlights("Boston", "London");

        Assert.assertEquals(5, flightOptionsPage.getOptionsCount());

        flightOptionsPage.selectFlight("234");

        Assert.assertTrue(driver.getPageSource().contains("Airline: United Airlines"));
        Assert.assertTrue(driver.getPageSource().contains("Flight Number: 234"));
    }
}

