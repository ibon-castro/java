package com.example.demo;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.demo.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        strict = true
)
public class CucumberTestRunner {
}
