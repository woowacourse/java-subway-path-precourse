package subway.exception;

public class InvalidCommandException extends IllegalArgumentException {
    private static final String message = "[ERROR] 유효하지 않은 기능입니다.\n";

    @Override
    public String getMessage() {
        return message;
    }
}