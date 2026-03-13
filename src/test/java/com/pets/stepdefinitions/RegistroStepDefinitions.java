package com.pets.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class RegistroStepDefinitions {

    @Given("se crea una mascota con los siguientes detalles")
    public void crearMascota() {
        // Step definition placeholder
    }

    @When("se consulta la mascota por su ID")
    public void obtenerMascota() {
        // Step definition placeholder
    }

    @Then("los detalles de la mascota deben coincidir con la mascota creada")
    public void validarMascotaCreada() {
        // Step definition placeholder
    }

    @And("los detalles de la mascota se actualizan con nueva información")
    public void actualizarMascota() {
        // Step definition placeholder
    }

    @Then("los detalles actualizados de la mascota deben reflejarse")
    public void validarMascotaActualizada() {
        // Step definition placeholder
    }

    @And("se elimina la mascota por su ID")
    public void eliminarMascota() {
        // Step definition placeholder
    }

    @Then("la mascota ya no debe existir")
    public void validarMascotaEliminada() {
        // Step definition placeholder
    }
}