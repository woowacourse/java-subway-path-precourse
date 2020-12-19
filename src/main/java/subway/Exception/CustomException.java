package subway.Exception;

public class CustomException extends RuntimeException{

    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public CustomException(String message) {
        super(ERROR_PREFIX + message);
    }
}
