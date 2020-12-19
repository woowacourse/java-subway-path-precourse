package subway.exception;

public class CannotFindCommandException extends RuntimeException {
    private final static String MESSAGE = "선택할 수 없는 기능입니다.  (입력 값: '%s')";

    public CannotFindCommandException(String command) {
        super(String.format(MESSAGE, command));
    }
}