package subway.domain;

import subway.views.OutputConstant;

public enum RouteMenu {
    SHORTEST_DISTANCE("1", "최단 거리"),
    SHORTEST_TIME("2", "최소 시간"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private final String option;
    private final String description;

    RouteMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    @Override
    public String toString() {
        return option + OutputConstant.OPTION_SEPARATOR + description;
    }
}
