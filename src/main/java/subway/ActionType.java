package subway;

public enum ActionType {

    SHORTEST_DISTANCE_PATH("최단 거리"),
    SHORTEST_TIME_PATH("최소 시간"),
    BACK("돌아가기");

    private final String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
