package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "home")
    WebElement homeLink;

    @FindBy(name = "fromPort")
    WebElement fromPortField;

    @FindBy(name = "toPort")
    WebElement toPortField;

    @FindBy(className = "btn-primary")
    WebElement findFlightsButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        homeLink.click();
        return new LoginPage(driver);
    }

    public FlightOptionsPage findFlights(String from, String to) {
        new Select(fromPortField).selectByVisibleText(from);
        new Select(toPortField).selectByVisibleText(to);
        findFlightsButton.click();
        return new FlightOptionsPage(driver);
    }
}
