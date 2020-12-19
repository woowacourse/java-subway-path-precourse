package subway.exception;

public class StationNotFoundException extends RuntimeException {
    private static final String STATION_NOT_FOUND_EXCEPTION_MESSAGE = "역을 찾을 수 없습니다.";

    public StationNotFoundException() {
        super(STATION_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
