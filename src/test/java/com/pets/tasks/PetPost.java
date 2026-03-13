
package com.pets.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.annotations.Step;

public class PetPost implements Task {
    private final String requestBody;

    public PetPost(String requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    @Step("{0} realiza un POST de mascota con el cuerpo de la petición")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/pet").with(request -> request
                .header("Content-Type", "application/json")
                .body(requestBody)
            )
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
