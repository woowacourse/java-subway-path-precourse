package subway.exception;

public class TransitRouteException extends IllegalArgumentException{
    private static final String ERROR = "[ERROR] ";

    public TransitRouteException(String message) {
        super(ERROR + message);
    }
}
