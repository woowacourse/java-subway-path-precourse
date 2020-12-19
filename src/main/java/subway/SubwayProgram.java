package subway;

import subway.domain.MainMenuType;
import subway.domain.RouteCheckType;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        MainMenuType mainMenuType;
        do {
            mainMenuType = InputView.inputMainMenu(scanner);
            selectMainMenu(mainMenuType);
        }while (!MainMenuType.END_PROGRAM.equals(mainMenuType));
    }


    private void selectMainMenu(MainMenuType mainMenuType) {
        if (MainMenuType.ROUTE_CHECK.equals(mainMenuType)) {
            runRouteCheckMenu();
        }
    }

    private void runRouteCheckMenu() {
        RouteCheckType routeCheckType;
        do {
            routeCheckType = InputView.inputRouteCheckType(scanner);
            selectRouteCheck(routeCheckType);
        }while (!RouteCheckType.BACK.equals(routeCheckType));
    }

    private void selectRouteCheck(RouteCheckType routeCheckType) {
        if (RouteCheckType.SHORTEST_DISTANCE.equals(routeCheckType)) {
            return;
        }
        if (RouteCheckType.MINIMUM_TIME.equals(routeCheckType)) {

        }
    }
}
