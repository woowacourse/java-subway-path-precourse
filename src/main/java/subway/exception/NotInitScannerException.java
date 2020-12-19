package subway.exception;

public class NotInitScannerException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] initScanner를 통해  Scanner를 먼저 넣어주세요.";

    public NotInitScannerException() {
        super(ERROR_MESSAGE);
    }
}
