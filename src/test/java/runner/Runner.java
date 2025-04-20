package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/loginPageNegativeScenarios",
        glue = {"steps", "hooks"},
        plugin = {
        "pretty",
        "html:target/cucumber-html-report.html",
        "json:target/cucumber-report.json"
}
)
public class Runner extends AbstractTestNGCucumberTests {
}
