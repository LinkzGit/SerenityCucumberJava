package Oslo.serenity.stepdefinitions;

import Oslo.serenity.pageobject.meliPage;
import Oslo.utils.Oslo;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class meliSteps {

    String url = "https://www.mercadolibre.com.ar";

    @Given("^I navigate to meli$")
    public void landingPage() {
        Oslo.navegarA(url);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Oslo");
    }

    @Then("^I do the search$")
    public void searchForProducts() {
        theActorInTheSpotlight().attemptsTo(

            Oslo.escribir("Yerba", meliPage.SEARCH_BOX),
            Oslo.clickEn(meliPage.SEARCH_BTN),
            Oslo.clickEn(meliPage.PRIMER_YERBA),
            Oslo.clickEn(meliPage.AGREGAR_UNO_MAS),
            Oslo.clickEn(meliPage.AGREGAR_AL_CARRITO),
            Oslo.navegarAtras(),
            Oslo.clickEn(meliPage.SEARCH_BOX),
            Oslo.escribir("Zapatillas Montage", meliPage.SEARCH_BOX),
            Oslo.clickEn(meliPage.SEARCH_BTN),
            Oslo.scrollToBottom(),
            Oslo.clickEn(meliPage.COMPRAR_ZAPATILLAS),
            Oslo.clickEn(meliPage.ELEGIR_COLOR),
            Oslo.clickEn(meliPage.ELEGIR_TALLE)
        );

    }

   //@Then("I can verify evrth")

}
