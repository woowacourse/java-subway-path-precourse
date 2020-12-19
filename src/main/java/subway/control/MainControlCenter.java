package subway.control;

import subway.enums.initializer.InitialLines;
import subway.enums.initializer.InitialRoutes;
import subway.enums.initializer.InitialStations;
import subway.enums.menu.MainMenu;
import subway.service.DistanceNavigator;
import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    RouteControlCenter woowahanMap;

    public MainControlCenter() {
        woowahanMap = new RouteControlCenter();
        InitialStations.initializeStations();
        InitialLines.initializeLines();
        InitialRoutes.initializeRoutes();
    }

    public static String inputCommand(Scanner scanner) {
        String command = scanner.nextLine();
        System.out.println();
        return command.trim();
    }

    public void startMainControl(Scanner scanner) {
        String view = "";
        while (!view.equalsIgnoreCase("Q")) {
            showMainMenu();
            String command = inputCommand(scanner);
            view = getViewByCommand(command, scanner);
        }
    }

    private String getViewByCommand(String command, Scanner scanner) {
        if (command.equals(MainMenu.SEARCH_ROUTE.getCommand()))
            return woowahanMap.startRouteControl(scanner);
        return "";
    }

    private void showMainMenu() {
        MainView.printMainMenu();
        MainView.askInputMenu();
    }

}
