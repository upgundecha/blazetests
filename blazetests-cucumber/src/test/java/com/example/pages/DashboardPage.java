package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    @FindBy(className = "dropdown-toggle")
    WebElement userNameLabel;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userNameLabel.getText();
    }

    public boolean isLoaded() {
        return driver.getPageSource().contains("Dashboard");
    }

    public HomePage logout() {
        userNameLabel.click();
        logoutLink.click();
        return new HomePage(driver);
    }
}
