package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features",
		glue = "StepDefinitions",
		plugin = {"pretty", "html:target/report-html"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner {
	
	

}
