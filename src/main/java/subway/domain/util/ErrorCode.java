package subway.domain.util;

public enum ErrorCode {
    // 명령어 관련 오류
    INVALID_COMMAND("선택할 수 없는 기능입니다."),

    // 역 관련 오류
    INVALID_STATION_NAME("역 이름은 온전한 한글로만 이루어져야 하며, 3글자 이상이어야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
