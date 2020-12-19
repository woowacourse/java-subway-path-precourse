package subway.view.resource;

public enum ErrorCode {
    INVALID_FUNCTION("선택할 수 없는 기능입니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
