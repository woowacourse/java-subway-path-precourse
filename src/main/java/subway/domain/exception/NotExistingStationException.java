package subway.domain.exception;

public class NotExistingStationException extends IllegalArgumentException {
    public NotExistingStationException() {
        super("존재하지 않는 역입니다.");
    }
}
