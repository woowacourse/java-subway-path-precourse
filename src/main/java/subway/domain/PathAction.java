package subway.domain;

import subway.controller.SubwayController;

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

    public static boolean isBack(String inputAction) {
        if (inputAction.equals(BACK.actionNumber)) {
            return true;
        }
        if (inputAction.equals(SHORTEST_DISTANCE.actionNumber) || inputAction.equals(SHORTEST_TIME.actionNumber)) {
            return false;
        }
        throw new IllegalArgumentException("옳지 않은 경로 기준 기능입니다.");
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionName() {
        return actionName;
    }
}
