package subway.error;

public class SameNameException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 출발역과 도착역이 동일합니다.";

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
