package subway.view.constants;

public enum PathInputOption {
    INITIAL_BLANK(""),
    PATH_SCREEN("## 경로 기준"),
    MINIMUM_DISTANCE("1. 최단 거리"),
    MINIMUM_TIME("2. 최소 시간"),
    BACK("B. 종료"),
    BLANK(""),
    ASK("## 원하시는 기능을  선택하세요.");

    final private String message;

    private PathInputOption(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
