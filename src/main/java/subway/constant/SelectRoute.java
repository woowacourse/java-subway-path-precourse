package subway.constant;

public enum SelectRoute {
    SHORTEST_PATH("1. 최단 거리"),
    MINIMUM_TIME("2. 최소 시간"),
    BACK("B. 돌아가기");

    public final String message;

    SelectRoute(String message) {
        this.message = message;
    }

}
