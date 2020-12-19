package subway.domain.exception;

public class InvalidMenuSelectException extends IllegalArgumentException {
    public InvalidMenuSelectException() {
        super("적절하지 않은 메뉴 선택입니다.");
    }
}
