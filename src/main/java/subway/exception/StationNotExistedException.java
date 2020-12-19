package subway.exception;

public class StationNotExistedException extends IllegalArgumentException {
    private static final String message = "[ERROR] 해당 역은 존재하지 않습니다.\n";

    @Override
    public String getMessage() {
        return message;
    }
}