package subway.exception;

public class InvalidChoiceException extends RuntimeException {
    private static final String STATION_NOT_CONNECTED_EXCEPTION_MESSAGE = "잘못된 선택입니다.";

    public InvalidChoiceException() {
        super(STATION_NOT_CONNECTED_EXCEPTION_MESSAGE);
    }
}
