package subway.exception;

public class CannotFindStationByName extends RuntimeException{
    private static final String MESSAGE = "등록되지 않은 역입니다.";

    public CannotFindStationByName(String name) {
        super(MESSAGE);
    }
}
