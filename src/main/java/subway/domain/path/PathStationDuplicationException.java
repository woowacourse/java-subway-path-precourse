package subway.domain.path;

public class PathStationDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "출발역과 도착역이 동일합니다.";

    public PathStationDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
