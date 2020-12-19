package subway.domain.exception;

public class NoConnectionPathException extends RuntimeException {
    private static final String MESSAGE = "경로를 찾을 수 없습니다.";

    public NoConnectionPathException() {
        super(MESSAGE);
    }
}
