### Additional Resources

* Selenium Cookbook Samples - https://github.com/upgundecha/secookbook
* Sample HTML Pages - http://seleniumacademy.com/cookbook/
* Locator Game - http://locator-game.seleniuminaction.com/
* The Internet Application - http://the-internet.herokuapp.com/
* Selenium Tips Code - https://github.com/tourdedave/elemental-selenium-tips

### TestNG CSV Data Provider

```
@DataProvider(name = "options")
public Iterator<Object[]> provider() throws Exception {
    List<Object[]> testCases = new ArrayList<Object[]>();
    String[] data = null;
    String line = "";
    int cnt = 0;

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

```

### JavaScriptExecutor Examples

```
public static void highlightElement(WebElement element) {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    for (int i = 0; i < 5; i++) {
        jsExecutor.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                element, "color: green; border: 2px solid green;");
        jsExecutor.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                element, "");
    }
}

public static void accessibilityScan() throws Exception {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    URL url = new URL("https://raw.githubusercontent.com/GoogleChrome/" + 
            "accessibility-developer-tools/stable/dist/js/axs_testing.js");
    InputStream is = url.openStream();

    String script = IOUtils.toString(is, StandardCharsets.UTF_8);
    jsExecutor.executeScript(script);
    String report = 
            (String) jsExecutor.executeScript("var results = axs.Audit.run();return axs.Audit.createReport(results);");
    System.out.println(report);
}

```

### Setting Selenium Grid

#### Hub

```
java -jar selenium-server-standalone-3.7.1.jar -role hub
```

#### Chrome Node

```
java -Dwebdriver.chrome.driver="chromedriver.exe" -jar selenium-server-standalone-3.7.1.jar -role webdriver -browser "browserName=chrome,maxinstance=2,platform=WINDOWS" -hubHost localhost -port 7777

```

### Web Table Class
```
package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WebTable {

    WebElement parent;

    public WebTable(WebElement element) {
        this.parent = element;
    }

    public int getRowCount() {
        return parent.findElements(By.cssSelector("tbody tr")).size();
    }

    public int getColumnCount() {
        return parent.findElements(By.cssSelector("thead > tr > th, thead > tr > td")).size();
    }

    public List<String> getColumnNames() {

        List<WebElement> columns =
                parent.findElements(By.cssSelector("thead > tr > th, thead > tr > td"));
        
        List<String> columnName = columns
                .stream()
                .map(c -> c.getText())
                .collect(Collectors.toList());

        return columnName;
    }

    public String[][] getData() {

        String data[][] =
                new String[getRowCount()][getColumnCount()];

        List<WebElement> rows =
                parent.findElements(By.cssSelector("tbody tr"));

        int r = 0;
        
        for(WebElement row : rows) {
            List<WebElement> cols =
                    row.findElements(By.cssSelector("td"));
            
            int c = 0;
            
            for(WebElement col : cols) {
                data[r][c] = col.getText();
                c++;
            }
            r++;
        }
        return data;
    }

    public String getCellData(int row, int col) {
        String data[][] = getData();
        return data[row][col];
    }
}
```

### Google Signup Month Selector Example

```
@Test
public void googleSignUp()  {
    driver = getDriver();

    driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
    selectMonthByIndex(8);
}

public void selectMonthByIndex(int index) {
    driver.findElement(By.cssSelector("span#BirthMonth div.goog-flat-menu-button-dropdown")).click();
    //driver.findElement(By.cssSelector("span#BirthMonth div.goog-menuitem:nth-of-type(" + index + ")")).click();
    driver.findElement(By.xpath("//span[@id='BirthMonth']//div[@class='goog-menuitem'][" + index + "]")).click();
}
```
