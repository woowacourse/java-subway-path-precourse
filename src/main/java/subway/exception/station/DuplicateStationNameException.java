package subway.exception.station;

public class DuplicateStationNameException extends IllegalArgumentException {

    private static final String MESSAGE = "'%s'은 이미 존재합니다.";

    public DuplicateStationNameException(String station) {
        super(String.format(MESSAGE, station));
    }
}
