package Oslo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/DEMOQA.feature"},
        plugin = {"pretty"},
        glue = "Oslo.serenity.stepdefinitions",
        tags = ""
)
public class DemoQArunner {
}