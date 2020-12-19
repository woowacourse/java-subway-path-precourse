package subway.control;

import subway.enums.menu.MainMenu;
import subway.enums.menu.RouteSearchMenu;
import subway.view.MainView;
import subway.view.RouteView;

import java.util.Scanner;

public class RouteControlCenter {

    public String startRouteControl(Scanner scanner) {
        RouteView.printRouteMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectRouteMenu(command, scanner);
        return MainMenu.SEARCH_ROUTE.getCommand();
    }

    private String selectRouteMenu(String command, Scanner scanner) {
        if (command.equals(RouteSearchMenu.SHORTEST_DISTANCE.getCommand()))
            return searchShortestDistance(scanner);
        if (command.equals(RouteSearchMenu.MINIMUM_TIME.getCommand()))
            return "";
        if (command.equalsIgnoreCase(RouteSearchMenu.BACK.getCommand()))
            return RouteSearchMenu.BACK.getCommand();
        return "";
    }

    private String searchShortestDistance(Scanner scanner) {
        String departure = inputDeparture(scanner);
        String arrival = inputArriaval(scanner);

        return RouteSearchMenu.SHORTEST_DISTANCE.getCommand();
    }

    private String inputDeparture(Scanner scanner) {
        RouteView.askInputDeparture();
        return MainControlCenter.inputCommand(scanner);
    }

    private String inputArriaval(Scanner scanner) {
        RouteView.askInputArrival();
        return MainControlCenter.inputCommand(scanner);
    }

}
