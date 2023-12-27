package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { ".//Features"},
    glue = "stepDefinitions", // Specify the package where step definitions are located
    dryRun = false,
    monochrome = true,
    plugin = { "pretty", "html:test-output/cucumber-report.html" },
 // tags = "@sanity and @regression"
		  tags = "@sanity or @regression"
)

public class testRun {

}