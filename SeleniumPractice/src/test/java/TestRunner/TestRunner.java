package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature/login.feature", 
					glue="",
					plugin = {"pretty","html:target/cucumber"})
public class TestRunner {
		
}
