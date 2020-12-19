package subway.type;

public enum TextType {
    ORIGIN_TEXT("## 출발역을 입력하세요."),
    DESTINATION_TEXT("## 도착역을 입력하세요."),

    TOTAL_DISTANCE("총 거리: "),
    KILOMETER("km\n"),

    TOTAL_TIME("총 소요 시간: "),
    MINUTE("분\n"),

    NEW_LINE("\n");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
