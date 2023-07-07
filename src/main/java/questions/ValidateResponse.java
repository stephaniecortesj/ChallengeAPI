package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor

public class ValidateResponse implements Question<Boolean> {

    private final Integer responseCode;

    public static ValidateResponse byCode(int responseCode){
        return new ValidateResponse(responseCode);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode()==responseCode;
    }
}
