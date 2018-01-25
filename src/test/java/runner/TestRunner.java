package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "features", glue= {"stepDefinition"}, format = {"pretty", "html:reports/target"})
public class TestRunner {

}
