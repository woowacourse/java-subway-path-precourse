package subway.exception;

public class CannotFindLineException extends RuntimeException{
    public static final String MESSAGE = "존재하지 않는 노선입니다.";

    public CannotFindLineException() {
        super(MESSAGE);
    }
}
