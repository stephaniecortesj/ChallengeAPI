package exceptions;

public class GetFailedResponseCode extends AssertionError {

    public static final String FAILED_RESPONSE_CODE = "The response code obtained is not equal to the expected one.";

    public GetFailedResponseCode(String ErrorMessage, Throwable causeOfError) {
        super(ErrorMessage, causeOfError);

    }
}
