package subway.domain.util;

public enum InfoCode {
    // 기타
    LINE("---"),
    BLANK_LINE("\n");

    private final String message;

    InfoCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
