package subway;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CategoryType {

    STATION(
        "경로 조회",
        Arrays.asList(ActionType.SHORTEST_DISTANCE_PATH, ActionType.SHORTEST_TIME_PATH)),
    EXIT(
        "종료",
        Collections.emptyList());

    private final String name;
    private final List<ActionType> actionOrder;

    CategoryType(String name, List<ActionType> actionOrder) {
        this.name = name;
        this.actionOrder = actionOrder;
    }

    public String getName() {
        return name;
    }

    public List<ActionType> getActionOrder() {
        return actionOrder;
    }
}
