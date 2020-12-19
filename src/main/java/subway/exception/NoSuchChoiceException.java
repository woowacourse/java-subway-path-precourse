package subway.exception;

public class NoSuchChoiceException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    public NoSuchChoiceException() {
        super(ERROR_MESSAGE);
    }
}