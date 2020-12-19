package subway.menus;

import subway.service.DistanceRouteService;
import subway.service.RouteService;
import subway.service.TimeRouteService;
import subway.views.OutputConstant;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public enum RouteMenu {
    SHORTEST_DISTANCE("1", "최단 거리", DistanceRouteService::getInstance),
    SHORTEST_TIME("2", "최소 시간", TimeRouteService::getInstance),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기", () -> {
        return null;
    });

    private final String option;
    private final String description;
    private final Supplier<RouteService> routeService;

    RouteMenu(String option, String description, Supplier<RouteService> routeService) {
        this.option = option;
        this.description = description;
        this.routeService = routeService;
    }

    public static void execute(String selectedOption, Scanner scanner) {
        Arrays.stream(values())
            .filter(routeMenu -> routeMenu.option.equals(selectedOption))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(OutputConstant.NOT_EXIST_OPTION_ERROR))
            .routeService
            .get()
            .routingService(scanner);
    }

    @Override
    public String toString() {
        return option + OutputConstant.OPTION_SEPARATOR + description;
    }
}
