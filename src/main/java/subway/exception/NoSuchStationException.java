package subway.exception;

public class NoSuchStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 역입니다.";

    public NoSuchStationException() {
        super(ERROR_MESSAGE);
    }
}
