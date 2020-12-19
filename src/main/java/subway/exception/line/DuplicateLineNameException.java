package subway.exception.line;

public class DuplicateLineNameException extends IllegalArgumentException {

    private static final String MESSAGE = "'%s'은 이미 존재합니다.";

    public DuplicateLineNameException(String line) {
        super(String.format(MESSAGE, line));
    }
}
