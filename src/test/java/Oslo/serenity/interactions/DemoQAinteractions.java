package Oslo.serenity.interactions;

import Oslo.serenity.tasks.DemoQaTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class DemoQAinteractions {
    public static Performable camposDatosPersonales(){
        return Task.where("Este llena los campos personales",
                DemoQaTask.fillName(),
                DemoQaTask.fillSurname(),
                DemoQaTask.fillEmail(),
                DemoQaTask.selectGender()
        );
    }
}
 /*   public static Task uploadFile(){
 #      return Task.thatPerforms(
                Enter.theValue("C:\\Users\\Linkz\\Desktop\\GQdYoK2bwAApMA3.jpeg").into("//label[contains(text(),'Select picture')]")
    }*/
