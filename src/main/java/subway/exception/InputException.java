package subway.exception;

public class InputException extends RuntimeException {

    public static final String MESSAGE = "잘못된 입력입니다. 다시 입력해주세요";

    public InputException() {
        super(MESSAGE);
    }

    public InputException(String message) {
        super(message);
    }
}
