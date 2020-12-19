package subway;

import subway.domain.MainMenuType;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;
    private final RouteCheckController routeCheckController;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
        routeCheckController = new RouteCheckController(scanner);
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
            routeCheckController.runRouteCheckMenu();
        }
    }
}
