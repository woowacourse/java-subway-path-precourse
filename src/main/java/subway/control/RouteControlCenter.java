package subway.control;

import subway.enums.menu.MainMenu;
import subway.view.MainView;
import subway.view.RouteView;

import java.util.Scanner;

public class RouteControlCenter {

    public String startRouteControl(Scanner scanner) {
        RouteView.printRouteMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);

        return MainMenu.SEARCH_ROUTE.getCommand();
    }
}
