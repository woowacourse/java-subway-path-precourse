package subway.controller;

public enum PathSearchScreenFunction {
    SHORTEST_PATH("1", "최단 거리"),
    MINIMUM_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private String code;
    private String title;

    PathSearchScreenFunction(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
