package Oslo.serenity.stepdefinitions;

import Oslo.serenity.pageobject.meliPage;
import Oslo.utils.Oslo;
import io.cucumber.java.en.*;

public class meliSteps {
    String url = "https://www.mercadolibre.com.ar";

    @Given("I navigate to meli")
    public void landingPage() {
        Oslo.navegarA(url);
    }

    @When("I do the search")
    public void searchForYerba() {
        Oslo.escribir("Yerba", meliPage.SEARCH_BOX);
        Oslo.clickEn(meliPage.PRIMER_YERBA);
        Oslo.clickEn(meliPage.AGREGAR_UNO_MAS);

    }

}
