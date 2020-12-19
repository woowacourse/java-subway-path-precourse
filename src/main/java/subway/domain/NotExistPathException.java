package subway.domain;

public class NotExistPathException extends RuntimeException {
    private static final String ERROR_MESSAGE = "출발역에서 도착역까지 갈 수 있는 경로가 없습니다.";

    public NotExistPathException() {
        super(ERROR_MESSAGE);
    }
}
