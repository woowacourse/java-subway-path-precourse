package subway.exception;

public class InvalidDistanceException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 거리는 0이하가 될 수 없습니다. INPUT:%s";

    public InvalidDistanceException(long input) {
        super(String.format(ERROR_MESSAGE, input));
    }
}
