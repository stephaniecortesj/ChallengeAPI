package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
@AllArgsConstructor
public class ValidarUsuario implements Question<Boolean> {

    private final String nombreUsuario;

    public static ValidarUsuario porNombre(String nombreUsuario) {
        return new ValidarUsuario(nombreUsuario);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().jsonPath().getString("data[0].first_name").equals(nombreUsuario);
    }
}
