package subway.exception;

public class InvalidInputException extends RuntimeException {

    private ExceptionCode exceptionCode;

    public InvalidInputException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public enum ExceptionCode {
        INVALID_FUNCTION_CODE,
        INVALID_BASIS_CODE,
        INVALID_SRC_AND_DST,
        NO_SUCH_STATION,
        NO_PATH_AVAILABLE
    }

    public String getMessage() {
        if (exceptionCode.equals(ExceptionCode.INVALID_FUNCTION_CODE))
            return "선택할 수 없는 기능입니다.";
        if (exceptionCode.equals(ExceptionCode.INVALID_BASIS_CODE))
            return "선택할 수 없는 기준입니다.";
        if (exceptionCode.equals(ExceptionCode.INVALID_SRC_AND_DST))
            return "출발역과 도착역이 동일합니다.";
        if (exceptionCode.equals(ExceptionCode.NO_SUCH_STATION))
            return "존재하지 않는 역 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.NO_PATH_AVAILABLE))
            return "존재하지 않는 경로입니다.";
        return "";
    }
}
