import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class PetPut implements Task {
	private final String body;

	public PetPut(String body) {
		this.body = body;
	}

	public static PetPut withBody(String body) {
		return Tasks.instrumented(PetPut.class, body);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Put.to("/pet")
				.with(request -> request
					.header("Content-Type", "application/json")
					.body(body)
				)
		);
	}
}
