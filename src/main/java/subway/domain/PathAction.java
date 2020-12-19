package subway.domain;

import subway.controller.SubwayController;

import java.util.function.BiFunction;

public enum PathAction {
    SHORTEST_LENGTH("1", "최단 거리", SubwayController::makeShortestLength),
    SHORTEST_TIME("2", "최소 시간", SubwayController::makeShortestTime),
    BACK("B", "돌아가기", null);

    private String actionNumber;
    private String actionName;
    private BiFunction<Station, Station, Boolean> action;

    PathAction(String actionNumber, String actionName, BiFunction<Station, Station, Boolean> action) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;
        this.action = action;
    }

    public static PathAction makePathAction(String receiveAction) {
        if (receiveAction.equals(BACK.actionNumber)) {
            return BACK;
        }
        if (receiveAction.equals(SHORTEST_LENGTH.actionNumber)) {
            return SHORTEST_LENGTH;
        }
        if (receiveAction.equals(SHORTEST_TIME.actionNumber)) {
            return SHORTEST_TIME;
        }
        throw new IllegalArgumentException("옳지 않은 경로 기준 기능입니다.");
    }

    public boolean doAction(Station start, Station finish) {
        return this.action.apply(start, finish);
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionName() {
        return actionName;
    }
}
