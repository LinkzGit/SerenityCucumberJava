package Oslo.serenity.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class meliPage {
    public static Target SEARCH_BOX = Target.the("Search Box").located(By.xpath("/html/body/header/div/div[2]/form/input"));
    public static Target SEARCH_BTN = Target.the("Search Button").located(By.xpath("//header/div[1]/div[2]/form[1]/button[1]/div[1]"));
    public static Target PRIMER_YERBA = Target.the("Primer opcion").located(By.xpath("//body/main[@id='root-app']/div[1]/div[3]/section[1]/ol[1]/li[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[3]/a[1]/div[1]/img[1]"));
    public static Target AGREGAR_AL_CARRITO = Target.the("Opcion agregar al carrito").located(By.xpath("//span[normalize-space()='Agregar al carrito']"));
    public static Target VER_MAS_PRODUCTOS_FULL = Target.the("Ver opcion full").located(By.xpath("//span[normalize-space()='Ver más productos Full']"));
    public static Target VER_CARRITO_SIDE_VIEW = Target.the("Ver opcion del carrito sideview").located(By.xpath("//span[contains(text(),'Ir al carrito')]"));
    public static Target OPCION_ELIMINAR = Target.the("Esta es la opcion de eliminar").located(By.xpath("//span[contains(text(),'Eliminar')]"));
    public static Target CONTINUAR_COMPRA = Target.the("Opcion continuar la compra").located(By.xpath("//span[contains(text(),'Continuar compra')]"));
    public static Target AGREGAR_UNO_MAS = Target.the("Opcion agregar uno mas").located(By.xpath("//main[@id='root-app']/div/div/div/div/section/article/div/section/div/div/form/button[2]/span"));
    public static Target COMPRAR_ZAPATILLAS = Target.the("Busca Zapatillas").located(By.xpath("//*[@id=:Rlql5ee:]/div[2]/h2/a"));
    public static Target ELEGIR_TALLE = Target.the("Elige talle").located(By.xpath("//body/main[@id='root-app']/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/a[2]/div[1]"));
    public static Target ELEGIR_COLOR = Target.the("Elige color rosa").located(By.xpath("//body/main[@id='root-app']/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/a[3]/div[1]/img[1]"));
}
