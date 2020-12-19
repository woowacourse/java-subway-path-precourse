package subway.domain.exception;

public class InvalidTimeException extends IllegalArgumentException {
    public InvalidTimeException(String msg) {
        super(msg);
    }
}
