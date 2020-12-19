package subway.domain.menu;

import subway.controller.Controller;
import subway.controller.RouteController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static RouteMenu findMenu(String name) {
        return Arrays.stream(RouteMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }

    public static List<String> list() {
        return Arrays.stream(RouteMenu.values())
                .map(routeMenu -> routeMenu.menu)
                .collect(Collectors.toList());
    }

    public void run() {
        if (isRunning()) {
            runnable.run();
        }
    }

    private boolean isRunning() {
        return !Objects.equals(RouteMenu.BACK, this);
    }
}
