package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetLista implements Interaction {
    public static Performable usersExisting() {
        return instrumented(GetLista.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/api/users")
                .with(request -> request
                        .header("Content-Type", "application/json").log().body()));
        System.out.println(SerenityRest.lastResponse().body().asString());
    }
}