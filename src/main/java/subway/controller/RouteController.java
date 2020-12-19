package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class RouteController {
    private static final String ROUTE_MENU = "Route";
    private static final String FINDING_MIN_DISTANCE = "1";
    private static final String FINDING_MIN_TIME = "2";

    private InputView inputView;

    public RouteController(InputView inputView) {
        this.inputView = inputView;
    }

    public void goToRouteMenu() {
        OutputView.printRouteMenu();
        String selection = inputView.receiveMenuSelection(ROUTE_MENU);
    }
}
