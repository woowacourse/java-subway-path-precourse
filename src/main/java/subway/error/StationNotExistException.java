package subway.error;

public class StationNotExistException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 역입니다.";

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
