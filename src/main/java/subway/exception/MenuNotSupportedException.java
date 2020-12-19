package subway.exception;

public class MenuNotSupportedException extends SubwayMapException {
    private static final String message = "[ERROR] 선택할 수 없는 기능입니다.";

    public MenuNotSupportedException() {
        super(message);
    }
}
