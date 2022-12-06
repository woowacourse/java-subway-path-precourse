package subway.domain.util;

public enum ErrorCode {
    // 명령어 관련 오류
    INVALID_COMMAND("선택할 수 없는 기능입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
