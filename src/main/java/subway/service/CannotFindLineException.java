package subway.service;

public class CannotFindLineException extends RuntimeException {
    private static final String ERROR_MESSAGE = "해당 이름의 노선을 조회할 수 없습니다.";

    public CannotFindLineException() {
        super(ERROR_MESSAGE);
    }
}
