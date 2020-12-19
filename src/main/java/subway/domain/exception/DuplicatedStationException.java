package subway.domain.exception;

@SuppressWarnings("serial")
public class DuplicatedStationException extends IllegalStateException {
    private static final String MESSAGE = "출발역과 도착역이 동일합니다.";

    public DuplicatedStationException() {
        super(MESSAGE);
    }
}
