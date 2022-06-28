package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Standard runner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepDefinitions",
        plugin = {"pretty"},
        tags = "@count or @RegEx")
public class TestRunner {
}
