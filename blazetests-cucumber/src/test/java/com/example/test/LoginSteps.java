package com.example.test;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("^user is on Login page$")
    public void user_is_on_Login_page() throws Throwable {
        driver.get("http://www.blazedemo.com/login");
    }

    @When("^he enters his credentials:$")
    public void he_enters_his_credentials(Map<String, String> userDetails) throws Throwable {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login(userDetails.get("email"),
                userDetails.get("password"));
    }

    @Then("^he should see the Dashboard$")
    public void he_should_see_the_Dashboard() throws Throwable {
        Assert.assertTrue(dashboardPage.isLoaded());
    }

    @Then("^he should see error message$")
    public void he_should_see_error_message(String message) throws Throwable {
        Assert.assertEquals(message, loginPage.getMessage());
    }
}
