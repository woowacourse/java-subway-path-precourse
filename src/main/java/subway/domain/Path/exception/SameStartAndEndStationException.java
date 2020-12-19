package subway.domain.Path.exception;

public class SameStartAndEndStationException extends IllegalArgumentException {

    private static final String MESSAGE = "출발역과 도착역은 달라야 합니다. (입력 값: '%s, %s')";

    public SameStartAndEndStationException(final String start, final String end) {
        super(String.format(MESSAGE, start, end));
    }
}
