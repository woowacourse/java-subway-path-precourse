package subway.exception;

public class InvalidStationNameException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 역 이름은 2글자 이상 설정할 수 있습니다.";

    public InvalidStationNameException() {
        super(ERROR_MESSAGE);
    }
}
