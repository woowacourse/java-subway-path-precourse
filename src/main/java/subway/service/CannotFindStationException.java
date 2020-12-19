package subway.service;

public class CannotFindStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "해당 이름의 역을 조회할 수 없습니다.";

    public CannotFindStationException() {
        super(ERROR_MESSAGE);
    }
}
