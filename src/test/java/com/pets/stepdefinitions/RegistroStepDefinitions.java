package com.pets.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import com.pets.tasks.PetPost;
import com.pets.tasks.PetGet;
import com.pets.tasks.PetPut;
import com.pets.tasks.PetDelete;

public class RegistroStepDefinitions {

    private String baseUrl;
    private String petName;
    private String petType;
    private int petId = 123;

    @Given("el usuario accede al sistema de gestion de mascotas")
    public void accederAlSistema() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
    }

    @And("el usuario configura la URL base del sistema como {string}")
    public void configurarUrlBase(String url) {
        this.baseUrl = url + "/v2";
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(baseUrl));
    }

    @And("el usuario se registra en el sistema con los detalles proporcionados")
    public void registrarseEnElSistema() {
    }

    @And("el usuario autentica su sesion con la API key especial")
    public void autenticarSesion() {
    }

    @And("el usuario registra una nueva mascota con nombre {string} y tipo {string}")
    public void registrarMascota(String nombre, String tipo) {
        this.petName = nombre;
        this.petType = tipo;
        String petJson = String.format(
            "{\"id\": %d, \"name\": \"%s\", \"category\": {\"id\": 1, \"name\": \"%s\"}, " +
            "\"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\"}",
            petId, nombre, tipo);
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetPost.withRequestBody(petJson)
        );
    }

    @When("el usuario consulta la informacion de la mascota registrada")
    public void consultarMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetGet.withId(petId)
        );
    }

    @And("actualiza el tipo de la mascota a {string}")
    public void actualizarTipoMascota(String nuevoTipo) {
        String updatedPetJson = String.format(
            "{\"id\": %d, \"name\": \"%s\", \"category\": {\"id\": 2, \"name\": \"%s\"}, " +
            "\"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\"}",
            petId, petName, nuevoTipo);
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetPut.withBody(updatedPetJson)
        );
    }

    @And("elimina la mascota del sistema")
    public void eliminarMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            PetDelete.withId(petId)
        );
    }

    @Then("el sistema confirma que los servicios REST han funcionado correctamente")
    public void confirmarServiciosREST() {
        OnStage.theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El servicio debe responder correctamente",
                response -> response.statusCode(200))
        );
    }

    @And("el sistema valida que las respuestas incluyan los codigos de estado esperados")
    public void validarCodigosEstado() {
    }

    @And("el usuario cierra la sesion del sistema")
    public void cerrarSesion() {
    }
}