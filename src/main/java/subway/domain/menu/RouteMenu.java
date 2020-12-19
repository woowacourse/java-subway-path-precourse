package subway.domain.menu;

import subway.controller.RouteController;

public enum RouteMenu {
    SHORTEST_DISTANCE("1", "1. 최단 거리\n", RouteController::shortestDistance),
    SHORTEST_TIME("2", "2. 최소 시간\n", RouteController::shortestTime),
    BACK("B", "B. 돌아가기\n", null);

    private String button;
    private String menu;
    private Runnable runnable;

    RouteMenu(String button, String menu, Runnable runnable) {
        this.button = button;
        this.menu = menu;
        this.runnable = runnable;
    }

}
