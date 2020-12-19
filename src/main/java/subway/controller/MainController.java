package subway.controller;

import subway.InitialSetter;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private static final String MAIN_MENU = "Main";
    private static final String ROUTE_MENU = "1";

    private InputView inputView;
    private String selection;

    public MainController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        final InitialSetter initialSetter = new InitialSetter();
        initialSetter.setInitialSubwayInfo();
        goToMainMenu();
    }

    private void goToMainMenu() {
        OutputView.printMainMenu();
        selection = inputView.receiveMenuSelection(MAIN_MENU);
        goToRouteMenu();
    }

    private void goToRouteMenu() {
        if (isSelect(ROUTE_MENU)) {
            RouteController routeController = new RouteController(inputView);
            routeController.goToRouteMenu();
        }
    }

    private boolean isSelect(String menu) {
        return selection.equals(menu);
    }
}
