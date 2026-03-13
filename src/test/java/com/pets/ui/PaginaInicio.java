import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio {

    public static final Target SECCION_PET = Target.the("Sección pet")
            .locatedBy("//div[contains(@id, 'pet-section')]");

    public static final Target BOTON_POST = Target.the("Add a new pet to the store")
            .locatedBy("//button[contains(text(), 'Add a new pet')]");

    public static final Target BOTON_PUT = Target.the("Update an existing pet")
            .locatedBy("//button[contains(text(), 'Update pet')]");

    public static final Target BOTON_GET = Target.the("Find pet by ID")
            .locatedBy("//button[contains(text(), 'Find pet')]");

    public static final Target BOTON_DELETE = Target.the("Deletes a pet")
            .locatedBy("//button[contains(text(), 'Delete pet')]");
}
