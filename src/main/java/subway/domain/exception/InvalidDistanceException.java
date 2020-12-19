package subway.domain.exception;

public class InvalidDistanceException extends IllegalArgumentException {
    public InvalidDistanceException(String msg) {
        super(msg);
    }
}
