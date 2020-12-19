package subway.domain.exception;

public class NoSuchStationException extends RuntimeException {
    private static final String MESSAGE = "등록되지 않은 역입니다.";

    public NoSuchStationException() {
        super(MESSAGE);
    }
}
