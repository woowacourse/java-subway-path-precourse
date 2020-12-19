package subway.exception;

public class DuplicatedLineException extends RuntimeException {

    public static final String MESSAGE = "노선 이름이 중복되었습니다.";

    public DuplicatedLineException() {
        super(MESSAGE);
    }
}
