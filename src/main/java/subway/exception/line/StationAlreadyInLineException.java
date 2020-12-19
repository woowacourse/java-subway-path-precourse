package subway.exception.line;

public class StationAlreadyInLineException extends IllegalArgumentException {

    private static final String MESSAGE = "'%s'은 이미 호선에 존재합니다.";

    public StationAlreadyInLineException(String station) {
        super(String.format(MESSAGE, station));
    }
}
