package subway.domain;

public class NotExistStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "지하철 역 리스트에 존재하지 않는 지하철 역입니다.";

    public NotExistStationException() {
        super(ERROR_MESSAGE);
    }
}
