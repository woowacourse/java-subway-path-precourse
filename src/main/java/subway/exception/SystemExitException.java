package subway.exception;

public class SystemExitException extends RuntimeException{

    public static final String MESSAGE = "시스템 종료";

    public SystemExitException() {
        super(MESSAGE);
    }
}
