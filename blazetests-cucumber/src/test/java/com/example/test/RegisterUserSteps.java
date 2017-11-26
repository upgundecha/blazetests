package com.example.test;

import com.example.pages.DashboardPage;
import com.example.pages.RegisterPage;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterUserSteps {

    WebDriver driver;
    RegisterPage registerPage;
    DashboardPage dashboardPage;

    Faker faker = new Faker();
    String name = faker.name().fullName();
    String company = faker.company().name();
    String email = faker.internet().emailAddress();

    public RegisterUserSteps() {
        this.driver = Hooks.getDriver();
        faker = new Faker();
    }
    @Given("^user is on registration page$")
    public void user_is_on_registration_page() throws Throwable {
        driver.get("http://www.blazedemo.com/register");
    }

    @When("^submits the registration form with all the fields$")
    public void submits_the_registration_form_with_all_the_fields() throws Throwable {
        registerPage = new RegisterPage(driver);
        dashboardPage = registerPage.registerUser(name, company,
                email, "p@ssword");
    }

    @Then("^he should see the Dashboard page$")
    public void he_should_see_the_Dashboard() throws Throwable {
        Assert.assertTrue(dashboardPage.isLoaded());
        Assert.assertEquals(dashboardPage.getUserName(), name);
    }
}
