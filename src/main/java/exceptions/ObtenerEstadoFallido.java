package exceptions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtenerEstadoFallido extends AssertionError {

    public static final String ESTADO_FALLIDO
}


public class CodigoRespuestaServicioError extends AssertionError {

    public static final String CODIGO_RESPUESTA_SERVICIO =
            "El código de respuesta obtenido no es igual al esperado";

    public CodigoRespuestaServicioError(String mensaje, Throwable causa) {
        super(mensaje, causa);