package subway.exception;

public class SubwayCustomException extends RuntimeException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public SubwayCustomException(String message) {
        super(ERROR_PREFIX + message);
    }
}
