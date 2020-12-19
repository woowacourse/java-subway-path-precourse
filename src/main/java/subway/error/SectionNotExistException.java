package subway.error;

public class SectionNotExistException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 존재하지 않는 구간입니다.";

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
