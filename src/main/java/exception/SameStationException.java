package exception;

public class SameStationException extends RuntimeException implements Exception {
    public final static String CAUSE = "동일한 역 이름을 입력하셨습니다.";

    public SameStationException() {
        super(ERROR + CAUSE);
    }
}
