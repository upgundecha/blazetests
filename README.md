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
