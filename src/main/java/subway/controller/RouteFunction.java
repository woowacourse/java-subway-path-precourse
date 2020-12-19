package subway.controller;

import java.util.Arrays;
import subway.exception.GoBackException;
import subway.exception.InputException;
import subway.service.RouteService;
import subway.view.OutputView;

public enum RouteFunction {
    SHORTEST_DISTANCE("1", "최단 거리", RouteFunction::retrieveByShortestDistance),
    SHORTEST_TIME("2", "최소 시간", RouteFunction::retrieveByShortestTime),
    GO_BACK("B", "돌아가기", RouteFunction::goBack);

    private static final RouteService routeService = new RouteService();

    private final String button;
    private final String detail;
    private final Runnable runnable;

    RouteFunction(String button, String detail, Runnable runnable) {
        this.button = button;
        this.detail = detail;
        this.runnable = runnable;
    }

    public static void printFunctions() {
        OutputView.printRouteFunction(RouteFunction.values());
    }

    public static void runFunction(String inputString) {
        Arrays.stream(RouteFunction.values())
                .filter(routeFunction -> routeFunction.button.equals(inputString))
                .findAny()
                .orElseThrow(InputException::new)
                .runnable.run();
    }

    private static void retrieveByShortestDistance() {
        routeService.retrieveByShortestDistance();
    }

    private static void retrieveByShortestTime() {
        routeService.retrieveByShortestTime();
    }

    private static void goBack() {
        throw new GoBackException();
    }

    @Override
    public String toString() {
        return button + ". " + detail;
    }
}
