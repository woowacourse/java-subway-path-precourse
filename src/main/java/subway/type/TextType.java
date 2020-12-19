package subway.type;

public enum TextType {
    ORIGIN_TEXT("## 출발역을 입력하세요."),
    DESTINATION_TEXT("## 도착역을 입력하세요.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
