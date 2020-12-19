package subway.view.screen.exception;

public class NotSupportedFunctionException extends RuntimeException {
    private static final String MESSAGE = "선택할 수 없는 기능입니다.";

    public NotSupportedFunctionException() {
        super(MESSAGE);
    }
}
