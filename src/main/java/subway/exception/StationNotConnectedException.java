package subway.exception;

public class StationNotConnectedException extends RuntimeException {
    private static final String STATION_NOT_CONNECTED_EXCEPTION_MESSAGE = "역이 이어져 있지 않습니다.";

    public StationNotConnectedException() {
        super(STATION_NOT_CONNECTED_EXCEPTION_MESSAGE);
    }
}
