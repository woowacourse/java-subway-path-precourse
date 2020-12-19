package subway.exception;

public class SectionStationDuplicateException extends SubwayMapException {
    private static final String message = "[ERROR] 출발역과 도착역은 같을 수 없습니다.";

    public SectionStationDuplicateException() {
        super(message);
    }
}
