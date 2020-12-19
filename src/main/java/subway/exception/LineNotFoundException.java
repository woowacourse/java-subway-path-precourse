package subway.exception;

public class LineNotFoundException extends RuntimeException {
    private static final String LINE_NOT_FOUND_EXCEPTION_MESSAGE = "노선을 찾을 수 없습니다.";

    public LineNotFoundException() {
        super(LINE_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
