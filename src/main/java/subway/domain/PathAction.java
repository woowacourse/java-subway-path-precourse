package subway.domain;

public enum PathAction {
    SHORTEST_DISTANCE("1", "최단 거리"),
    SHORTEST_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private String actionNumber;
    private String actionName;

    PathAction(String actionNumber, String actionName) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionName() {
        return actionName;
    }
}
