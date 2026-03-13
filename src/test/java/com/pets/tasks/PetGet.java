package com.pets.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.Tasks;

public class PetGet implements Task {
	private final int petId;

	public PetGet(int petId) {
		this.petId = petId;
	}

	public static PetGet withId(int petId) {
		return Tasks.instrumented(PetGet.class, petId);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		String resource = "/pet/" + petId;
		actor.attemptsTo(
			Get.resource(resource)
		);
	}
}
