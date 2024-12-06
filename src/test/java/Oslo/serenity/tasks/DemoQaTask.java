package Oslo.serenity.tasks;

import Oslo.serenity.pageobject.formsPage;
import Oslo.utils.Oslo;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoQaTask extends Oslo {

    public static Performable clicFormsPage() {
        return Oslo.clickEn(formsPage.FORMS_PAGE);
    }

    public static Performable clicAgainFormsPage() {
        return Oslo.clickEn(formsPage.PRACTICE_FORM);
    }

    public static Performable fillName() {
        return Oslo.escribir("Ian", formsPage.NAME_FIELD);
    }

    public static Performable fillSurname() {
        return Oslo.escribir("Zonca", formsPage.SURNAME_FIELD);
    }

    public static Performable fillEmail() {
        return Oslo.escribir("dasdasasdasd@hotmail.com", formsPage.EMAIL_FORM);
    }

    public static Performable selectGender() {
        return Oslo.clickEn(formsPage.MALE_LABEL);
    }

    public static Performable clickCallendar() {
        return Oslo.clickEn(formsPage.DATE_BIRTH);
    }

    public static Performable fillCallendar() {
        return Task.where(
                "Presento los datos para callendar",
                Oslo.escribir("18oct95", formsPage.DATE_BIRTH),
                SendKeys.of("\n").into(formsPage.DATE_BIRTH)
        );
    }

    public static Performable clickSubject() {
        return Oslo.clickEn(formsPage.SUBJECT_FIELD);
    }

    public static Performable fillSubject() {
        return Oslo.escribir("asdasdasd", formsPage.SUBJECT_FIELD);
    }

    public static Performable fillHobbies() {
        return Task.where(
                "Relleno los hobbiees",
                Oslo.desplazarHasta(formsPage.HOBBIES_READING),
                Oslo.clickEn(formsPage.HOBBIES_READING),
                Oslo.clickEn(formsPage.HOBBIES_SPORTS),
                Oslo.clickEn(formsPage.HOBBIES_MUSIC)
        );

    }
    public static Performable fillPhone() { return Oslo.escribir("1539261132", formsPage.MOBILE_NUMBER);}
    public static Performable clickSubmit() {
        return Oslo.clickEn(formsPage.SUBMIT_BUTTON);
    }

    public static Performable fillAddress() {
        return Oslo.escribir("VelezPepito 2800", formsPage.ADDRESS_BOX);
    }


    public static Performable subirArchivo(String filePath, Target locator) {
        Path file = Paths.get(filePath);
        return Task.where("{0} uploads the file",
                Upload.theFile(file).to(locator)
        );
    }
}








