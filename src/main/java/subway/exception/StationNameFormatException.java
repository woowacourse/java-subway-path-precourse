package subway.exception;

public class StationNameFormatException extends RuntimeException {
    private static final String STATION_NAME_FORMAT_EXCEPTION_MESSAGE = "역의 이름이 올바르지 않습니다.";
    public StationNameFormatException() {
        super(STATION_NAME_FORMAT_EXCEPTION_MESSAGE);
    }
}
