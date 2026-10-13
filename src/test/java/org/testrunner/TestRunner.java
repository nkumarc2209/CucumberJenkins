package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Vishnu\\eclipse-workspace\\cucumberprog\\src\\test\\resources\\res\\datatable.feature",
    glue = "org.stepdefinitions",
    		plugin = {
    				"pretty",
    				"html:target/cucumber-report.html"
    				}
)
public class TestRunner {
	
	
}

