package subway.exception;

public class SubwayException extends IllegalArgumentException{
    private static final String ERROR = "[ERROR] ";

    public SubwayException(String message) {
        super(ERROR + message);
    }
}
