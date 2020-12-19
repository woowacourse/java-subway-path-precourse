package subway.domain.exception;

public class SamePointsException extends RuntimeException {
    private static final String SAME_POINTS_ERROR_MESSAGE = "\n[ERROR] 출발역과 도착역이 동일합니다.";

    public SamePointsException() {
        super(SAME_POINTS_ERROR_MESSAGE);
    }
}