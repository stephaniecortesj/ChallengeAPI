package stepdefinitions;

import io.cucumber.java.es.Cuando;

import static exceptions.ObtenerEstadoFallido.ESTADO_FALLIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import exceptions.ObtenerEstadoFallido;
import questions.ValidarUsuario;
import questions.ValidateCode;
import task.Listar;

public class GestionUsuarioStepDefinition {


    private EnvironmentVariables environmentVariables;

    @Cuando("^(.*) realiza la consulta de los usuarios existentes$")
    public void realizarConsulta(String nombreActor) {
        theActorCalled(nombreActor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl"))).
                attemptsTo(Listar.usuarios());
    }

    @Entonces("^obtengo el estado (.*)$")
    public void validarStatus(int codeStatus) {
        theActorInTheSpotlight().should(seeThat(ValidateCode.byStatus(codeStatus))
                .orComplainWith(ObtenerEstadoFallido.class, ESTADO_FALLIDO+"400"));
    }

    @Entonces("^valido que la lista de usuarios exista (.*)$")
    public void validarUsuario(String nombreUsuario) {
        theActorInTheSpotlight().should(seeThat(ValidarUsuario.porNombre(nombreUsuario))
                .orComplainWith(ObtenerEstadoFallido.class, ESTADO_FALLIDO+"201"));
    }
}
