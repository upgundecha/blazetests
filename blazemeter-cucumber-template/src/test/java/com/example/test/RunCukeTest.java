package com.example.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "com.cucumber.listener.ExtentCucumberFormatter:test-output/report.html"},
        features = {"."}
        )
public class RunCukeTest {
}
