package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ValidateName implements Question<Boolean> {

    private final String name;

    public static ValidateName byName(String name) {
        return new ValidateName(name);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getString("data[0].first_name").equals(name);
    }
}
