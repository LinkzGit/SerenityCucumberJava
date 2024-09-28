package Oslo.serenity.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class meliPage {
    public static Target SEARCH_BOX = Target.the("Search Box").located(By.xpath("//input[@id='cb1-edit']"));
    public static Target PRIMER_YERBA = Target.the("Primer opcion").located(By.xpath("//a[@title='Yerba Mate Cosmico 500g']"));
    public static Target AGREGAR_AL_CARRITO = Target.the("Opcion agregar al carrito").located(By.xpath("//span[normalize-space()='Agregar al carrito']"));
    public static Target VER_MAS_PRODUCTOS_FULL = Target.the("Ver opcion full").located(By.xpath("//span[normalize-space()='Ver más productos Full']"));
    public static Target VER_CARRITO_SIDE_VIEW = Target.the("Ver opcion del carrito sideview").located(By.xpath("//span[contains(text(),'Ir al carrito')]"));
    public static Target OPCION_ELIMINAR = Target.the("Esta es la opcion de eliminar").located(By.xpath("//span[contains(text(),'Eliminar')]"));
    public static Target CONTINUAR_COMPRA = Target.the("Opcion continuar la compra").located(By.xpath("//span[contains(text(),'Continuar compra')]"));
    public static Target AGREGAR_UNO_MAS = Target.the("Opcion agregar uno mas").located(By.xpath("//main[@id='root-app']/div/div/div/div/section/article/div/section/div/div/form/button[2]/span"));


}
