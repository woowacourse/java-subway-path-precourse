package subway.domain;

public class SameStationNameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "출발역과 도착역이 동일합니다.";

    public SameStationNameException() {
        super(ERROR_MESSAGE);
    }
}
