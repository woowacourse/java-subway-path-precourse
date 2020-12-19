package subway.exception;

public class DistanceTimeException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public DistanceTimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
