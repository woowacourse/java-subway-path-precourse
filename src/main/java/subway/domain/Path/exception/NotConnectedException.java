package subway.domain.Path.exception;

public class NotConnectedException extends IllegalArgumentException {

    private static final String MESSAGE = "출발역과 도착역이 연결되어 있지 않습니다. (입력 값: '%s, %s')";

    public NotConnectedException(final String start, final String end) {
        super(String.format(MESSAGE, start, end));
    }
}
