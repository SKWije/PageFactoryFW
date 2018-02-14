package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/cucumber/wikipedia.json",
                "html:target/cucumber/wikipedia.html",
                "pretty"},
        tags = {"~@ignored"},
        features = "src/test/resources/features/articles.feature",
        glue = "com.steps"
)
public class TestRunner {
}