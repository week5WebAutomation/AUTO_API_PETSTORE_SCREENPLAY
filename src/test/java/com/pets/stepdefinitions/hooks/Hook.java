import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import test.java.com.pets.util.Constantes;


public class Hook {
    @Before
    public void iniciarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        String theRestApiBaseUrl = Constantes.URL;
        OnStage.theActorCalled(Constantes.ACTOR).whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
