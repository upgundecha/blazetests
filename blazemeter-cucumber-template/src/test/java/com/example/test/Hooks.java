package com.example.test;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.UUID;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            String filename = UUID.randomUUID().toString();
            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File("./test-output/img/" + filename + ".png"));
            Reporter.addScreenCaptureFromPath("img/" + filename + ".png");
        }
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
