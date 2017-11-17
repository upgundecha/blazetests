### Additional Resources

* Selenium Cookbook Samples - https://github.com/upgundecha/secookbook
* Sample HTML Pages - http://seleniumacademy.com/cookbook/
* Locator Game - http://locator-game.seleniuminaction.com/
* The Internet Application - http://the-internet.herokuapp.com/
* Selenium Tips Code - https://github.com/tourdedave/elemental-selenium-tips

### Setting Selenium Grid

#### Hub

```
java -jar selenium-server-standalone-3.7.1.jar -role hub
```

#### Chrome Node

```
java -Dwebdriver.chrome.driver="chromedriver.exe" -jar selenium-server-standalone-3.7.1.jar -role webdriver -browser "browserName=chrome,maxinstance=2,platform=WINDOWS" -hubHost localhost -port 7777

```
