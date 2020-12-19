package subway.error;

public enum LineErrorMessage {
    NOT_EXIST_STATION("노선에 등록되어 있지 않는 역입니다.");

    private final String message;

    LineErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
