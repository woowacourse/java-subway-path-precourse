package subway.common;

public class ErrorCustomException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public ErrorCustomException(String message) {
        super(ERROR_PREFIX + message);
    }

}
