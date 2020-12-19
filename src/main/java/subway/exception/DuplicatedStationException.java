package subway.exception;

public class DuplicatedStationException extends RuntimeException {

    public static final String MESSAGE = "역 이름이 중복되었습니다.";

    public DuplicatedStationException() {
        super(MESSAGE);
    }
}
