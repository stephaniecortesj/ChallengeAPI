package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
@AllArgsConstructor
public class ValidateUser implements Question<Boolean> {

    private final String userName;

    public static ValidateUser byName(String userName) {
        return new ValidateUser(userName);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getString("data[0].first_name").equals(userName);
    }
}
