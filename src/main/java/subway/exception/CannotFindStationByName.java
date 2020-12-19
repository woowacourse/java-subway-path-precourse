package subway.exception;

public class CannotFindStationByName extends RuntimeException {
    private static final String MESSAGE = "등록되지 않은 역입니다. (입력 값: '%s')";

    public CannotFindStationByName(String name) {
        super(String.format(MESSAGE, name));
    }
}
