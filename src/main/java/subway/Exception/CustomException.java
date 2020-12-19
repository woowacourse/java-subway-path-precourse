package subway.Exception;

public class CustomException extends RuntimeException{

    public static final String NEW_LINE = "\n";
    public static final String PREFIX_ERROR = "[ERROR] ";
    private static final String ERROR_PREFIX = NEW_LINE + PREFIX_ERROR;

    public CustomException(String message) {
        super(ERROR_PREFIX + message);
    }
}
