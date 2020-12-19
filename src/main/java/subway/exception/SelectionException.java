package subway.exception;

public class SelectionException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public SelectionException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

