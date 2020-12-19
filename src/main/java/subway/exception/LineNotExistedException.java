package subway.exception;

public class LineNotExistedException extends IllegalArgumentException {
    private static final String message = "[ERROR] 해당 노선은 존재하지 않습니다.\n";

    @Override
    public String getMessage() {
        return message;
    }
}