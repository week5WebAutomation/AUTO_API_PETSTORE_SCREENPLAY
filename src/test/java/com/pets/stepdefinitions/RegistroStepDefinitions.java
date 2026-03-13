package com.pets.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;
import static org.hamcrest.Matchers.equalTo;
import test.java.com.pets.tasks.PetPost;
import test.java.com.pets.tasks.PetGet;
import test.java.com.pets.tasks.PetPut;
import test.java.com.pets.tasks.PetDelete;
import test.java.com.pets.util.Constantes;

public class RegistroStepDefinitions {

    @Given("el actor se registra en el sistema")
    public void registrarActor() {
        OnStage.theActorCalled(Constantes.ACTOR);
    }

    @Given("el actor se autentica con la API key especial")
    public void autenticarConApiKey() {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(Constantes.URL));
    }

    @Given("el actor crea una mascota con los siguientes detalles")
    public void crearMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetPost.defaultPet()
        );
    }

    @When("el actor consulta la mascota por su ID")
    public void obtenerMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetGet.withId(10)
        );
    }

    @Then("los detalles de la mascota deben coincidir con la mascota creada")
    public void validarMascotaCreada() {
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El recurso debe existir",
                response -> response.statusCode(200))
        );
    }

    @And("el actor actualiza los detalles de la mascota con nueva información")
    public void actualizarMascota() {
        String updatedPetJson = "{\n" +
                "  \"id\": 10,\n" +
                "  \"name\": \"catty\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Cats\"\n" +
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
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetPut.withBody(updatedPetJson)
        );
    }

    @Then("los detalles actualizados de la mascota deben reflejarse")
    public void validarMascotaActualizada() {
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El recurso actualizado debe existir",
                response -> response.statusCode(200))
        );
    }

    @And("el actor elimina la mascota por su ID")
    public void eliminarMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetDelete.withId(10)
        );
    }

    @Then("la mascota ya no debe existir")
    public void validarMascotaEliminada() {
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El recurso debe ser eliminado",
                response -> response.statusCode(200))
        );
    }

    @Then("se verifica que la mascota eliminada no exista y devuelva un error 404")
    public void verificarMascotaEliminada() {
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El recurso eliminado no debe existir",
                response -> response.statusCode(404))
        );
    }
}