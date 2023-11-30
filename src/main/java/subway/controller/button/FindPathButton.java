package subway.controller.button;

public enum FindPathButton {
    SHORTEST_DISTANCE("1", "최단 거리", null),
    SHORTEST_TIME("2", "최소 시간", null),
    BACK("B", "돌아가기", null),
    ;

    private final String input;
    private final String description;
    private final Runnable method;

    FindPathButton(String input, String description, Runnable method) {
        this.input = input;
        this.description = description;
        this.method = method;
    }
}
