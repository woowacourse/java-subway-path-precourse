package subway.exception;

public class SameStationsException extends RuntimeException {
    private static final String MESSAGE = "출발역과 도착역이 같습니다. (입력 값: '%s')";

    public SameStationsException(String name) {
        super(String.format(MESSAGE, name));
    }
}
