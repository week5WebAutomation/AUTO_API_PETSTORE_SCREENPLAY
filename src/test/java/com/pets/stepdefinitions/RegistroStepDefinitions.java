package com.pets.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class RegistroStepDefinitions {

    @Given("el actor se registra en el sistema")
    public void registrarActor() {
        // Step definition para registrar al actor
    }

    @Given("el actor se autentica con la API key especial")
    public void autenticarConApiKey() {
        // Step definition para autenticar con la API key
    }

    @Given("el actor crea una mascota con los siguientes detalles")
    public void crearMascota() {
        // Step definition para crear una mascota
    }

    @When("el actor consulta la mascota por su ID")
    public void obtenerMascota() {
        // Step definition para obtener una mascota
    }

    @Then("los detalles de la mascota deben coincidir con la mascota creada")
    public void validarMascotaCreada() {
        // Step definition para validar la mascota creada
    }

    @And("el actor actualiza los detalles de la mascota con nueva información")
    public void actualizarMascota() {
        // Step definition para actualizar una mascota
    }

    @Then("los detalles actualizados de la mascota deben reflejarse")
    public void validarMascotaActualizada() {
        // Step definition para validar la mascota actualizada
    }

    @And("el actor elimina la mascota por su ID")
    public void eliminarMascota() {
        // Step definition para eliminar una mascota
    }

    @Then("la mascota ya no debe existir")
    public void validarMascotaEliminada() {
        // Step definition para validar que la mascota fue eliminada
    }

    @Then("se verifica que la mascota eliminada no exista y devuelva un error 404")
    public void verificarMascotaEliminada() {
        // Step definition para verificar que la mascota eliminada no exista
    }

    @Given("el usuario se registra en el sistema con los detalles proporcionados")
    public void registrarUsuario() {
        // Step definition para registrar un usuario usando POST /user
    }

    @Then("el usuario cierra la sesión del sistema")
    public void cerrarSesionUsuario() {
        // Step definition para cerrar sesión usando GET /user/logout
    }

    @Given("el usuario configura la URL base del sistema como {string}")
    public void configurarUrlBase(String urlBase) {
        // Step definition para configurar la URL base del sistema
    }

    @Given("el usuario registra una nueva mascota con nombre {string} y tipo {string}")
    public void registrarNuevaMascota(String nombre, String tipo) {
        // Step definition para registrar una nueva mascota con nombre y tipo
    }

    @When("el usuario consulta la informacion de la mascota registrada")
    public void consultarInformacionMascota() {
        // Step definition para consultar la información de la mascota registrada
    }

    @And("actualiza el tipo de la mascota a {string}")
    public void actualizarTipoMascota(String nuevoTipo) {
        // Step definition para actualizar el tipo de la mascota
    }

    @And("elimina la mascota del sistema")
    public void eliminarMascotaDelSistema() {
        // Step definition para eliminar la mascota del sistema
    }

    @Then("el sistema confirma que los servicios REST han funcionado correctamente")
    public void confirmarServiciosRestFuncionaron() {
        // Step definition para confirmar que los servicios REST han funcionado correctamente
    }

    @Then("el sistema valida que las respuestas incluyan los codigos de estado esperados")
    public void validarCodigosEstadoEsperados() {
        // Step definition para validar que las respuestas incluyan los códigos de estado esperados
    }
}