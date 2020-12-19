package subway.domain.exception;

public class InvalidSearchingStationException extends IllegalArgumentException {
    public InvalidSearchingStationException(String msg) {
        super(msg);
    }
}
