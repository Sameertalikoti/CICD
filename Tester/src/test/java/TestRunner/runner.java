package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features", // Path to feature files
	    glue = "stepdefinition", // Path to step definition classes
	    plugin = {"pretty", "html:target/cucumber-report.html"}, // Report generation
	    monochrome = true // Clean console output
	)
	
public class runner{

}
