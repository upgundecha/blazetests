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
