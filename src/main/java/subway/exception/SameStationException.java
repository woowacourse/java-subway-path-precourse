package subway.exception;

public class SameStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 출발역과 도착역은 동일하면 안됩니다.";

    public SameStationException() {
        super(ERROR_MESSAGE);
    }
}
