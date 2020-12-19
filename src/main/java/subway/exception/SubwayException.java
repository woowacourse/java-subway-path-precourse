package subway.exception;

public class SubwayException extends IllegalArgumentException {

    public SubwayException(String message) {
        super("[ERROR] " + message);
    }
}
