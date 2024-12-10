package Oslo.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class Oslo {

    // Métodos de Selenium

    public static Performable escribir(String texto, Target elemento) {
        esperar(elemento);
        return Enter.theValue(texto).into(elemento);
    }

    public static Performable clickEn(Target elemento) {
        esperar(elemento);
        esperarhabilitado(elemento);
        return Click.on(elemento);
    }

    public static Performable esperar(Target elementos) {
        return Wait.until(
                WebElementQuestion.the(elementos), WebElementStateMatchers.isPresent()
        ).forNoMoreThan(30).seconds();
    }

    public static Performable esperarVisible(Target elemento) {
        return WaitUntil.the(elemento, WebElementStateMatchers.isVisible())
                .forNoMoreThan(30).seconds();
    }

    public static Performable esperarClicable(Target elemento) {
        return WaitUntil.the(elemento, WebElementStateMatchers.isClickable())
                .forNoMoreThan(30).seconds();
    }

    public static Performable esperarhabilitado(Target elementos) {
        return Wait.until(
                WebElementQuestion.the(elementos), WebElementStateMatchers.isEnabled()
        ).forNoMoreThan(30).seconds();
    }

    public static boolean estaVisible(Target elemento) {
        Actor actor = theActorInTheSpotlight();
        return elemento.resolveFor(actor).isVisible();
    }

    public static boolean estaHabilitado(Target elemento) {
        Actor actor = theActorInTheSpotlight();
        return elemento.resolveFor(actor).isEnabled();
    }

    public static String obtenerTexto(Target elemento) {
        Actor actor = theActorInTheSpotlight();
        return Text.of(elemento).answeredBy(actor).toString();
    }

    public static List<String> obtenerTextos(Target elementos) {
        Actor actor = theActorInTheSpotlight();
        List<WebElementFacade> elementosWeb = Target.the("elementos").locatedBy(elementos.getCssOrXPathSelector()).resolveAllFor(actor);

        return elementosWeb.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public static String obtenerColorFondo(Target elemento) {
        Actor actor = theActorInTheSpotlight();
        return elemento.resolveFor(actor).getCssValue("background-color");
    }

    public static Performable expandirMenu(Target menuSelector) {
        return MoveMouse.to(menuSelector);
    }

    public static String obtenerURLActual() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.getCurrentUrl();
    }

    public static void capturarPantalla(String nombreArchivo) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + nombreArchivo + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Performable esperarTexto(Target elemento, String texto) {
        return Wait.until(
                WebElementQuestion.the(elemento), WebElementStateMatchers.containsText(texto)
        ).forNoMoreThan(30).seconds();
    }

    public static String obtenerAtributo(Target elemento, String atributo) {
        Actor actor = theActorInTheSpotlight();
        return elemento.resolveFor(actor).getAttribute(atributo);
    }

    public static Performable esperarDesaparicion(Target elemento) {
        return WaitUntil.the(elemento, WebElementStateMatchers.isNotVisible())
                .forNoMoreThan(30).seconds();
    }

    public static Performable esperarDesaparicionPresencia(Target elemento) {
        return WaitUntil.the(elemento, WebElementStateMatchers.isNotPresent())
                .forNoMoreThan(30).seconds();
    }

    public static Performable desplazarHasta(Target elemento) {
        return Task.where("{0} desplaza hasta " + elemento, actor -> {
            WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
            WebElement webElement = elemento.resolveFor(actor);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        });
    }

    public static Performable cambiarAIFrame(Target iframe) {
        return Task.where("{0} cambia al iframe " + iframe, actor -> {
            WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
            WebElement webElement = iframe.resolveFor(actor);
            driver.switchTo().frame(webElement);
        });
    }

    public static Performable salirDeIFrame() {
        return Task.where("{0} sale del iframe", actor -> {
            WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
            driver.switchTo().defaultContent();
        });
    }

    public static void añadirCookie(String nombre, String valor) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        Cookie cookie = new Cookie(nombre, valor);
        driver.manage().addCookie(cookie);
    }

    public static Cookie obtenerCookie(String nombre) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.manage().getCookieNamed(nombre);
    }

    public static void eliminarCookie(String nombre) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.manage().deleteCookieNamed(nombre);
    }

    public static void eliminarTodasLasCookies() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.manage().deleteAllCookies();
    }

    public static void esperarHastaCondicionJS(String script) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript(script).equals(true)
        );
    }

    public static Performable navegarAtras() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.navigate().back();
        return null;
    }

    public static void navegarAdelante() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.navigate().forward();
    }

    public static void refrescarPagina() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.navigate().refresh();
    }

    public static void maximizarVentana() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.manage().window().maximize();
    }

    public static void cambiarTamañoVentana(int ancho, int alto) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.manage().window().setSize(new Dimension(ancho, alto));
    }

    public static Dimension obtenerTamañoVentana() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.manage().window().getSize();
    }

    public static Map<String, String> obtenerCookiesComoMapa() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.manage().getCookies().stream()
                .collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
    }

    public static int contarElementos(Target elementos) {
        Actor actor = theActorInTheSpotlight();
        return elementos.resolveAllFor(actor).size();
    }

    public static boolean elementoContieneTexto(Target elemento, String texto) {
        Actor actor = theActorInTheSpotlight();
        return elemento.resolveFor(actor).getText().contains(texto);
    }

    public static String obtenerPaginaFuente() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.getPageSource();
    }

    public static File capturarPantallaComoArchivo() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static Performable esperarInvisible(Target elemento) {
        return WaitUntil.the(elemento, WebElementStateMatchers.isNotVisible())
                .forNoMoreThan(30).seconds();
    }

    public static Performable esperarHastaQueElElementoContengaTexto(Target elemento, String texto) {
        return WaitUntil.the(elemento, WebElementStateMatchers.containsText(texto))
                .forNoMoreThan(30).seconds();
    }

    public static void cerrarPestana() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public static void cambiarANuevaPestana() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static Object ejecutarScript(String script) {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return ((JavascriptExecutor) driver).executeScript(script);
    }

    // Métodos de Serenity Rest

    public static Response realizarSolicitudGet(String endpoint) {
        return SerenityRest.given().get(endpoint);
    }

    public static Response realizarSolicitudPost(String endpoint, Object body) {
        return SerenityRest.given().body(body).post(endpoint);
    }

    public static Response realizarSolicitudPut(String endpoint, Object body) {
        return SerenityRest.given().body(body).put(endpoint);
    }

    public static Response realizarSolicitudDelete(String endpoint) {
        return SerenityRest.given().delete(endpoint);
    }

    public static Response realizarSolicitudPatch(String endpoint, Object body) {
        return SerenityRest.given().body(body).patch(endpoint);
    }

    public static Response realizarSolicitudConParametros(String endpoint, Map<String, String> parametros) {
        return SerenityRest.given().params(parametros).get(endpoint);
    }

    public static Response realizarSolicitudConEncabezados(String endpoint, Map<String, String> headers) {
        return SerenityRest.given().headers(headers).get(endpoint);
    }

    public static void verificarCodigoEstado(Response respuesta, int codigoEsperado) {
        respuesta.then().statusCode(codigoEsperado);
    }

    public static void verificarRespuestaContieneTexto(Response respuesta, String textoEsperado) {
        respuesta.then().body(containsString(textoEsperado));
    }

    public static void verificarClaveEnRespuesta(Response respuesta, String clave) {
        respuesta.then().body("$", hasKey(clave));
    }

    public static void verificarValorClaveEnRespuesta(Response respuesta, String clave, String valorEsperado) {
        respuesta.then().body(clave, equalTo(valorEsperado));
    }

    public static Response realizarSolicitudHead(String endpoint) {
        return SerenityRest.given().head(endpoint);
    }

    public static Response realizarSolicitudOptions(String endpoint) {
        return SerenityRest.given().options(endpoint);
    }

    public static void verificarValorEncabezado(Response respuesta, String encabezado, String valorEsperado) {
        respuesta.then().header(encabezado, equalTo(valorEsperado));
    }

    public static long obtenerTiempoRespuesta(Response respuesta) {
        return respuesta.time();
    }

    // Funcionalidades generales

    public static void esperarSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String obtenerTituloPagina() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        return driver.getTitle();
    }

    public static void navegarA(String url) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver.get(url);
    }

    public static void cerrarNavegador() {
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        driver.quit();
    }

    public static Performable setSessionStorageItem(String key, String value) {
        return Task.where("{0} sets sessionStorage item",
                actor -> {
                    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    System.out.println("Setting sessionStorage item: key=" + key + ", value=" + value); // Log para diagnóstico
                    js.executeScript(String.format("sessionStorage.setItem('%s', '%s');", key, value));
                    // Verificar si se ha seteado correctamente
                    String storedValue = (String) js.executeScript(String.format("return sessionStorage.getItem('%s');", key));
                    System.out.println("Stored value in sessionStorage: " + storedValue);
                }
        );
    }


    public static Performable scrollToTop() {
        return Task.where("{0} scrolls to the top of the page",
                actor -> {
                    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollTo(0, 0)");
                }
        );
    }
    public static Performable scrollToBottom() {
        return Task.where("{0} scrolls to the bottom of the page",
                actor -> {
                    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                }
        );
    }

    public static Performable subirArchivo(String filePath, Target locator) {
        Path file = Paths.get(filePath);
        return Task.where("{0} uploads the file",
                Upload.theFile(file).to(locator)
        );
    }
}
