package subway.message;

public enum CommonMessage implements Message {
    SELECT_FUNCTION("원하는 기능을 선택하세요."),
    ERROR_SELECT_FUNCTION("선택할 수 없는 기능입니다."),
    ;

    private String message;

    CommonMessage(String content) {
        this.message = content;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

