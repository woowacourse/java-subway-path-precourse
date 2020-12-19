package subway.domain.exception;

public class UnreachableStationException extends IllegalArgumentException {
    public UnreachableStationException() {
        super("도달할 수 없는 역입니다.");
    }
}
