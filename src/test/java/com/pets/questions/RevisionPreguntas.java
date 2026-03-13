package test.java.com.pets.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;

public class RevisionPreguntas implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = Serenity.getDriver();
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        alert.accept();
        return mensaje;
    }

    public static RevisionPreguntas mensaje() {
        return new RevisionPreguntas();
    }
}
