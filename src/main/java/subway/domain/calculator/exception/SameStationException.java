package subway.domain.calculator.exception;

public class SameStationException extends RuntimeException {
    private static final String MESSAGE = "출발역과 도착역이 동일합니다.";

    public SameStationException() {
        super(MESSAGE);
    }
}
