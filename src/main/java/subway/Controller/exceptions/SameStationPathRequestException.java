package subway.Controller.exceptions;

public class SameStationPathRequestException extends RuntimeException {
    private static final String MESSAGE = "출발역과 도착역이 같습니다.";

    public SameStationPathRequestException() {
        super(MESSAGE);
    }

}

