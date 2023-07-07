package exceptions;

public class GetFailedName extends AssertionError {

    public static final String FAILED_NAME = "The response name obtained is not equal to the expected one.";

    public GetFailedName(String ErrorMessage, Throwable causeOfError) {
        super(ErrorMessage, causeOfError);

    }
}
