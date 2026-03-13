package com.pets.stepdefinitions.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hook {

    @Before
    public void iniciarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        String theRestApiBaseUrl = "https://petstore.swagger.io/v2";
        OnStage.theActorCalled("Usuario").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @After
    public void finalizarEscenario() {
        OnStage.drawTheCurtain();
    }
}
