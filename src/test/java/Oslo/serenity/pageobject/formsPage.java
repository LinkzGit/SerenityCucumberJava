package Oslo.serenity.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class formsPage {
    public static final Target FORMS_PAGE = Target.the("fromulario a rellenar").located(By.xpath("//h5[contains(text(),'Forms')]"));
    public static Target NAME_FIELD = Target.the("Campo de primer nombre a rellenar").located(By.xpath("//input[@id='firstName']"));
    public static Target SURNAME_FIELD = Target.the("Campo de apellido a rellenar").located(By.xpath("//input[@id='lastName']"));
    public static Target PRACTICE_FORM = Target.the("Nuevo Formulario").located(By.xpath("//span[contains(text(),'Practice Form')]"));
    public static Target EMAIL_FORM = Target.the("Campo Email").located(By.xpath("//input[@id='userEmail']"));
    public static Target MALE_LABEL = Target.the("Opcion Sexo Masculino").located(By.xpath("//label[contains(text(),'Male')]"));
    public static Target FEMALE_LABEL = Target.the("Opcion Sexo Femenino").located(By.xpath("//label[contains(text(),'Female')]"));
    public static Target MOBILE_NUMBER = Target.the("Campo Numero Telefono").located(By.xpath("//input[@id='userNumber']"));
    public static Target DATE_BIRTH = Target.the("Campo Cumpleanito").located(By.xpath("//input[@id='dateOfBirthInput']"));
    public static Target SUBJECT_FIELD = Target.the("Campo Subject").located(By.xpath("//input[@id='subjectsInput']"));
    public static Target HOBBIES_SPORTS = Target.the("Label Sports ").located(By.xpath("//label[contains(text(),'Sports')]"));
    public static Target HOBBIES_READING = Target.the("Label Reading").located(By.xpath("//label[contains(text(),'Reading')]"));
    public static Target HOBBIES_MUSIC = Target.the("Label Music").located(By.xpath("//label[contains(text(),'Music')]"));
    public static Target CURRENT_ADRESS = Target.the("Target Area").located(By.xpath("//textarea[@id='currentAddress']"));
    public static Target UPLOAD_PICTURE_BTN = Target.the("Boton Upload Foto").located(By.xpath("//input[@id='uploadPicture']"));
    public static Target ADDRESS_BOX = Target.the("Direccion").located(By.xpath("//textarea[@id='currentAddress']"));
    public static Target STATE_BOX = Target.the("Estado").located(By.xpath("//div[contains(text(),'Select State')]"));
    public static Target CITY_BOX = Target.the("Ciudad").located(By.xpath("//div[contains(text(),'Select City')]"));
    public static Target SUBMIT_BUTTON = Target.the("Boton Submit").located(By.xpath("//button[@id='submit']"));

}
