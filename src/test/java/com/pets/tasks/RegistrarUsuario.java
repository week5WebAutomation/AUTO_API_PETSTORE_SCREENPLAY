package test.java.com.pets.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class RegistrarUsuario implements Task {

    private static final String ENV_API_KEY = "PETSTORE_API_KEY";
    private static final String DEFAULT_API_KEY = "special-key";

    private static final Target BOTON_AUTHORIZE = Target.the("Authorize button")
            .locatedBy("//button[contains(@class,'authorize') and contains(@class,'unlocked')]");

    private static final Target CAMPO_API_KEY = Target.the("API Key input field")
            .locatedBy("//h4[code[text()='api_key']]/following-sibling::*//input[@type='text']");

    private static final Target BOTON_AUTHORIZE_MODAL = Target.the("Authorize button in modal")
            .locatedBy("//div[h4[code[text()='api_key']]]//button[text()='Authorize']");

    private static final Target BOTON_CLOSE = Target.the("Close button")
            .locatedBy("//div[h4[code[text()='api_key']]]//button[text()='Close']");

    private final String apiKey;

    private RegistrarUsuario(String apiKey) {
        this.apiKey = apiKey;
    }

    private static String getApiKey() {
        String key = System.getenv(ENV_API_KEY);
        return (key != null && !key.isEmpty()) ? key : DEFAULT_API_KEY;
    }

    @Override
    @Step("{0} realiza la autenticación inicial con la API key")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(BOTON_AUTHORIZE),
            Enter.theValue(apiKey).into(CAMPO_API_KEY),
            Click.on(BOTON_AUTHORIZE_MODAL),
            Click.on(BOTON_CLOSE)
        );
    }

    public static RegistrarUsuario autenticacionInicial() {
        return new RegistrarUsuario(getApiKey());
    }

    public static RegistrarUsuario conApiKey(String apiKey) {
        return new RegistrarUsuario(apiKey);
    }
}
