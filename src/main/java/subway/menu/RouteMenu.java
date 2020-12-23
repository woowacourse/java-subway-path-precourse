package subway.menu;

import subway.controller.RouteController;
import subway.exception.TransitRouteException;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum RouteMenu {
    ROUTE_BY_DISTANCE("최단 거리", "1", RouteController::promptRouteByDistance),
    ROUTE_BY_TIME("최소 시간", "2", RouteController::promptRouteByTime),
    BACK("돌아가기", "B", RouteController::back);

    private static final String ERROR_CATEGORY_SELECTION = "잘못 입력 하셨습니다";

    RouteMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static RouteMenu findByCommand(String command) {
        return Arrays.stream(RouteMenu.values())
                .filter(stationMenu -> stationMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new TransitRouteException(ERROR_CATEGORY_SELECTION);
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(RouteMenu.values())
                .map(stationMenu -> stationMenu.title)
                .collect(toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(RouteMenu.values())
                .map(stationMenu -> stationMenu.command)
                .collect(toList());
    }

    public void run() {
        this.action.run();
    }
}
