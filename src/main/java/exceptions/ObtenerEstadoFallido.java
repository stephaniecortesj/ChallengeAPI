package exceptions;

public class ObtenerEstadoFallido extends AssertionError {

    public static final String ESTADO_FALLIDO = "El código de respuesta obtenido no es igual al esperado";

    public ObtenerEstadoFallido(String mensajeDeError, Throwable causaDelError) {
        super(mensajeDeError, causaDelError);

    }
}
