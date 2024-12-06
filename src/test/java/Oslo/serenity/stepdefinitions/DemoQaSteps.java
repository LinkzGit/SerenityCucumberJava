package Oslo.serenity.stepdefinitions;

import Oslo.serenity.interactions.DemoQAinteractions;
import Oslo.serenity.pageobject.formsPage;
import Oslo.serenity.questions.DemoQuestions;
import Oslo.serenity.tasks.DemoQaTask;
import Oslo.utils.Oslo;
import com.sun.security.auth.module.Krb5LoginModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.hamcrest.Matchers;


import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.core.injectors.*;

public class DemoQaSteps {
    private EnvironmentVariables environmentVariables;

    public DemoQaSteps() {
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    @Given("I navigate to DemoQA")
    public void ingresoLandingPage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Oslo");
        //Obtiene la URL
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url.pipeline");
        theActorInTheSpotlight().attemptsTo(Open.url(baseUrl));
        System.out.println("Opening URL: " + baseUrl);

    }

    @Then("I can click on the Forms option")
    public void clickFormsOption() {
        theActorInTheSpotlight().attemptsTo(
                Oslo.scrollToBottom(),
                Oslo.clickEn(formsPage.FORMS_PAGE),
                Oslo.clickEn(formsPage.PRACTICE_FORM)
        );

    }

    @And("Fill out the form")
    public void rellenarCampos() {
        String file = "src/test/resources/filesResources/GQhaRt9XQAAsVs4.jpeg";
        theActorInTheSpotlight().attemptsTo(
                Oslo.scrollToBottom(),
                DemoQAinteractions.camposDatosPersonales(),
                DemoQaTask.clickCallendar(),
                DemoQaTask.fillCallendar(),
                DemoQaTask.fillAddress(),
                DemoQaTask.fillHobbies(),
                DemoQaTask.fillSubject(),
                DemoQaTask.fillPhone()
        );
        theActorInTheSpotlight().attemptsTo(
                Oslo.subirArchivo(file,formsPage.UPLOAD_PICTURE_BTN)
        );

    }

    @And("Submit")
    public void sendSubmitButton() {
        theActorInTheSpotlight().attemptsTo(
                Oslo.scrollToBottom(),
                DemoQaTask.clickSubmit()
        );
    }
    @Then("I can check that it worked with no errors")
    public void checkFinalStep(){
        theActorInTheSpotlight().attemptsTo(
                Oslo.esperarTexto(formsPage.FINAL_STEP, "Thanks for submitting the form"));
    }

}