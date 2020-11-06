package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		plugin = {"pretty", "html:target/HTML/cucumber-html-report.html", "json:target/JSON/cucumber.json", "junit:target/XML/cucumber.xml"}, 
		glue = "stepDefinitions")

public class TestRunner {

}
