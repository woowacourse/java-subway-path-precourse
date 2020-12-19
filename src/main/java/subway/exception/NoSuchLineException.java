package subway.exception;

public class NoSuchLineException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 노선입니다.";

    public NoSuchLineException() {
        super(ERROR_MESSAGE);
    }
}
