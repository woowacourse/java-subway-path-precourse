package subway.domain.path;

public class CannotFindPathException extends RuntimeException {
    private static final String ERROR_MESSAGE = "경로를 조회할 두 지하철 역이 연결되어 있지 않습니다.";

    public CannotFindPathException() {
        super(ERROR_MESSAGE);
    }
}

