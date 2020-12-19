package subway.exception;

public class CannotFindStationException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 역입니다.";

    public CannotFindStationException() {
        super(MESSAGE);
    }
}
