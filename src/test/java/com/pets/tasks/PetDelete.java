package com.pets.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.Tasks;

public class PetDelete implements Task {
	private final long petId;
	private final String apiKey;

	public PetDelete(long petId, String apiKey) {
		this.petId = petId;
		this.apiKey = apiKey;
	}

	public static PetDelete withId(long petId) {
		return new PetDelete(petId, "");
	}

	public static PetDelete withIdAndApiKey(long petId, String apiKey) {
		return new PetDelete(petId, apiKey);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		String resource = "/pet/" + petId;
		if (apiKey != null && !apiKey.isEmpty()) {
			actor.attemptsTo(
				Delete.from(resource)
					.with(request -> request.header("api_key", apiKey))
			);
		} else {
			actor.attemptsTo(
				Delete.from(resource)
			);
		}
	}
}
