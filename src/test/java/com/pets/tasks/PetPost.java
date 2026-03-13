package test.java.com.pets.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class PetPost implements Task {

        // Sección pet (no es necesario hacer click, pero se deja para referencia)
        private static final Target SECTION_PET = Target.the("Pet section")
            .locatedBy("//section[.//h3[contains(.,'pet')]]");

        // Barra del endpoint POST /pet
        private static final Target POST_ENDPOINT_BAR = Target.the("POST /pet endpoint bar")
            .locatedBy("//button[contains(@class,'opblock-summary-control') and .//span[text()='POST'] and .//span[contains(text(),'/pet')]]");

        // Botón Try it out
        private static final Target TRY_IT_OUT_BUTTON = Target.the("Try it out button")
            .locatedBy("//button[@ref='e571'] | //button[contains(.,'Try it out')]");

        // Área de texto para el Request Body
        private static final Target REQUEST_BODY_TEXTAREA = Target.the("Request body textarea")
            .locatedBy("//textarea[contains(@placeholder,'Request Body')] | //textarea");

        // Botón Execute
        private static final Target EXECUTE_BUTTON = Target.the("Execute button")
            .locatedBy("//button[contains(.,'Execute')]");

    private final String requestBody;

    public PetPost(String requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    @Step("{0} realiza un POST de mascota con el cuerpo de la petición")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(SECTION_PET),
            Click.on(POST_ENDPOINT_BAR),
            Click.on(TRY_IT_OUT_BUTTON),
            Enter.theValue(requestBody).into(REQUEST_BODY_TEXTAREA),
            Click.on(EXECUTE_BUTTON)
        );
    }

    public static PetPost withRequestBody(String requestBody) {
        return new PetPost(requestBody);
    }

    public static PetPost defaultPet() {
        String defaultJson = "{\n" +
                "  \"id\": 10,\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dogs\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\"string\"],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        return new PetPost(defaultJson);
    }
}
