package subway.Exception;

public class SameStationException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 출발역과 도착역이 동일합니다.";

    public SameStationException() {
        super(MESSAGE);
    }
}
