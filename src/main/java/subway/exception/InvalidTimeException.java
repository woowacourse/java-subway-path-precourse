package subway.exception;

public class InvalidTimeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 시간은 0이하가 될 수 없습니다.INPUT:%s";

    public InvalidTimeException(long minute) {
        super(String.format(ERROR_MESSAGE, minute));
    }
}
