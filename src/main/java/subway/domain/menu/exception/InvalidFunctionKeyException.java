package subway.domain.menu.exception;

@SuppressWarnings("serial")
public class InvalidFunctionKeyException extends IllegalStateException {
    private static final String MESSAGE = "해당 기능은 존재하지 않습니다.";
    
    public InvalidFunctionKeyException() {
        super(String.format(MESSAGE));
    }
}
