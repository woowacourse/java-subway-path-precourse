package subway.exception;

public class SubwayException extends IllegalArgumentException {
    private static final String ERROR_MSG_PREFIX = "[ERROR] ";

    public SubwayException(String message) {
        super(ERROR_MSG_PREFIX + message);
    }
}
