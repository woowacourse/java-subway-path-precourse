package subway.exception;

public class SameStationException extends RuntimeException {
    private static final String SAME_STATION_EXCEPTION_MESSAGE = "역의 이름이 올바르지 않습니다.";

    public SameStationException() {
        super(SAME_STATION_EXCEPTION_MESSAGE);
    }
}
