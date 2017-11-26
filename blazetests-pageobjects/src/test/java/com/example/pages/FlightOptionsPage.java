package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightOptionsPage {

    WebDriver driver;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> flightOptions;

    public FlightOptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getOptionsCount() {
        return flightOptions.size();
    }

    public void selectFlight(String flightNumber) {
        driver.findElement(By
                .xpath("//td[text()='" + flightNumber +"']/parent::tr//input[@value='Choose This Flight']"))
                .click();
    }
}
