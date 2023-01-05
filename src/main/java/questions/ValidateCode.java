package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor

public class ValidateCode implements Question<Boolean> {

    private final Integer codeStatus;

    public static ValidateCode byStatus (int codeStatus){
        return new ValidateCode(codeStatus);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode()==codeStatus;
    }
}
