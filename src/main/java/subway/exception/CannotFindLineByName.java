package subway.exception;

public class CannotFindLineByName extends RuntimeException {
    private final static String MESSAGE = "등록된 노선이 아닙니다. (입력 값: '%s')";

    public CannotFindLineByName(String name) {
        super(String.format(MESSAGE, name));
    }
}
