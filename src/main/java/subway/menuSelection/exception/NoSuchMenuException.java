package subway.menuSelection.exception;

public class NoSuchMenuException extends RuntimeException {
    private static final String MESSAGE = "유효하지 않은 선택입니다.";

    public NoSuchMenuException() {
        super(MESSAGE);
    }
}
