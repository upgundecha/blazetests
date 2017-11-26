package com.example.test;

import com.example.util.SpreadsheetData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BookingTests extends BaseTest {

    WebDriver driver;

    @Test
    public void shouldDisplayFlightOptions() {

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

    @Test(dataProvider = "excelOptions")
    public void shouldDisplayFlightOptionsDDT(String from, String to, String options) {

        driver = getDriver();

        driver.get("http://www.blazedemo.com/");

        WebElement fromPort = driver.findElement(By.name("fromPort"));
        WebElement toPort = driver.findElement(By.name("toPort"));

        Select fromPortDropdown = new Select(fromPort);
        Select toPortDropdown = new Select(toPort);

        fromPortDropdown.selectByVisibleText(from);
        toPortDropdown.selectByVisibleText(to);

        driver.findElement(By.className("btn-primary")).click();

        List<WebElement> flightOptions =
                driver.findElements(By.xpath("//table/tbody/tr"));

        Assert.assertEquals(Integer.parseInt(options), flightOptions.size());
    }


    @DataProvider(name = "options")
    public Iterator<Object[]> provider() throws Exception {
        List<Object[]> testCases = new ArrayList<Object[]>();
        String[] data = null;
        String line = "";
        int cnt = 0;

        //this loop is pseudo code
        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/data/data.csv"));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            if (cnt > 0) {
                data = line.split(",");
                testCases.add(data);
            }
            cnt++;
        }
        return testCases.iterator();
    }

    @DataProvider(name = "excelOptions")
    public Object[][] getExcelData() throws InvalidFormatException, IOException {
        SpreadsheetData spreadsheetData = new SpreadsheetData();
        return spreadsheetData.getCellData("./src/test/resources/data/data.xls");
    }
}

