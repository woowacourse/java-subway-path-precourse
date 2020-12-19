package subway.exception;

public class LineNameFormatException extends RuntimeException {
    private static final String LINE_NAME_FORMAT_EXCEPTION_MESSAGE = "노선의 이름이 올바르지 않습니다.";
    public LineNameFormatException() {
        super(LINE_NAME_FORMAT_EXCEPTION_MESSAGE);
    }
}
