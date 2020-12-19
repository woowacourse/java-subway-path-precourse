package subway.domain.menu;

import subway.controller.Controller;
import subway.controller.DistanceGraphController;
import subway.controller.TimeGraphController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum RouteMenu {
    SHORTEST_DISTANCE("1", "1. 최단 거리\n", new DistanceGraphController()),
    SHORTEST_TIME("2", "2. 최소 시간\n", new TimeGraphController()),
    BACK("B", "B. 돌아가기\n", null);

    private String button;
    private String menu;
    private Controller controller;

    RouteMenu(String button, String menu, Controller controller) {
        this.button = button;
        this.menu = menu;
        this.controller = controller;
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
            controller.run();
        }
    }

    private boolean isRunning() {
        return !Objects.equals(RouteMenu.BACK, this);
    }
}
