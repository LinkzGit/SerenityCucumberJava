package Oslo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/MELI.feature"},
        glue = "Oslo.serenity.stepdefinitions",
        tags = ""
)
public class meliRunner {
}
