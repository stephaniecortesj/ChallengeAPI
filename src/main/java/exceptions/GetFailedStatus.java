package exceptions;

public class GetFailedStatus extends AssertionError {

    public static final String FAILED_STATE = "The response code obtained is not equal to the expected one.";

    public GetFailedStatus(String ErrorMessage, Throwable causeOfError) {
        super(ErrorMessage, causeOfError);

    }
}
