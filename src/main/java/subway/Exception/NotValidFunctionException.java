package subway.Exception;

public class NotValidFunctionException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 선택할수 없는 기능 입니다.";

    public NotValidFunctionException() {
        super(MESSAGE);
    }
}

