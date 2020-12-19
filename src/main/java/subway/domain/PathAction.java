package subway.domain;

import subway.controller.SubwayController;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public enum PathAction {
    SHORTEST_DISTANCE("1", "최단 거리", SubwayController::makeShortestLength),
    SHORTEST_TIME("2", "최소 시간", SubwayController::makeShortestTime),
    BACK("B", "돌아가기", null);

    private String actionNumber;
    private String actionName;
    private BiConsumer<Station, Station> action;

    PathAction(String actionNumber, String actionName, BiConsumer<Station, Station> action) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;
        this.action = action;
    }

    public static PathAction makePathAction(String receiveAction) {
        if (receiveAction.equals(BACK.actionNumber)) {
            return BACK;
        }
        if (receiveAction.equals(SHORTEST_DISTANCE.actionNumber)){
            return SHORTEST_DISTANCE;
        }
        if(receiveAction.equals(SHORTEST_TIME.actionNumber)) {
            return SHORTEST_TIME;
        }
        throw new IllegalArgumentException("옳지 않은 경로 기준 기능입니다.");
    }

    public void doAction(Station start, Station finish){
        this.action.accept(start, finish);
    }
    public String getActionNumber() {
        return actionNumber;
    }

    public String getActionName() {
        return actionName;
    }
}
