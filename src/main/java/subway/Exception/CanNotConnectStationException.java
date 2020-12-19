package subway.Exception;

public class CanNotConnectStationException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 연결되어 있지 않은 역입니다.";

    public CanNotConnectStationException() {
        super(MESSAGE);
    }
}
