package subway.view.resource;

public enum Message {
    REQUEST_FUNCTION_CODE("원하는 기능을 선택하세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
