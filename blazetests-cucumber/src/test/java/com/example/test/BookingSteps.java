package com.example.test;

import com.example.pages.FlightOptionsPage;
import com.example.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class BookingSteps {

    WebDriver driver;
    HomePage homePage;
    FlightOptionsPage flightOptionsPage;

    public BookingSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("^user is on Home page$")
    public void user_is_on_Home_page() throws Throwable {
       driver.get("http://www.blazedemo.com/");
    }

    @When("^he finds flight:$")
    public void he_finds_flight(Map<String, String> selection) throws Throwable {
        flightOptionsPage = new HomePage(driver)
                .findFlights(selection.get("from"), selection.get("to"));

    }

    @Then("^he should see the flight options$")
    public void he_should_see_the_flight_options() throws Throwable {
        Assert.assertEquals(5, flightOptionsPage.getOptionsCount());
    }

    @Then("^he selects flight \"([^\"]*)\"$")
    public void he_selects_flight(String flightNumber) throws Throwable {
        flightOptionsPage.selectFlight(flightNumber);
    }

    @Then("^he should see the flight details:$")
    public void he_should_see_the_flight_details(Map<String, String> flightDetails) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains("Airline: " + flightDetails.get("airline")));
        Assert.assertTrue(driver.getPageSource().contains("Flight Number: " + flightDetails.get("flight")));
    }
}
