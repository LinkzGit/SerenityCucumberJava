package Oslo.serenity.questions;

import Oslo.utils.Oslo;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Question;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class DemoQuestions {

    private EnvironmentVariables environmentVariables;
    private final String baseUrl;

    public DemoQuestions() {
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        this.baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webriver.base.url.pipeline");
    }
    //This will be validating that the actual Url is the Url we're expecting
    public Question<Boolean> PaginaEsperada() {
        return actor -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String urlActual = Oslo.obtenerURLActual();
            String urlEsperada = baseUrl;

            return urlActual.equals(urlEsperada);
        };
    }
    //This will be validating that the next Url is the Url we're expecting
    public Question<Boolean> paginaForm() {
        return actor -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String urlActual = Oslo.obtenerURLActual();
            String urlForm = "https://demoqa.com/forms";

            return urlActual.equals(urlForm);
        };

    }
}