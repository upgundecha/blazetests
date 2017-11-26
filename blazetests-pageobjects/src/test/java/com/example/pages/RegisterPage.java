package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "password-confirm")
    WebElement confirmPasswordField;

    @FindBy(className = "btn")
    WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DashboardPage registerUser(String name, String company,
                                      String email, String password) {

        nameField.sendKeys(name);
        companyField.sendKeys(company);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        registerButton.click();

        return new DashboardPage(driver);
    }
}
