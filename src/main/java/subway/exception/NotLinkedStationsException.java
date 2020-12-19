package subway.exception;

public class NotLinkedStationsException extends IllegalArgumentException {
    private static final String message = "[ERROR] 출발역과 도착역이 연결되어 있지 않습니다.";

    @Override
    public String getMessage() {
        return message;
    }
}