package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.MainMenuType;
import subway.domain.RouteCheckType;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;
    private final RouteCheckController routeCheckController;
    private final DijkstraShortestPath dijkstraShortestPath;

    public SubwayProgram(Scanner scanner, DijkstraShortestPath dijkstraShortestPath) {
        this.scanner = scanner;
        this.dijkstraShortestPath = dijkstraShortestPath;
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
            routeCheckController.selectShortestDistance(dijkstraShortestPath);
            return;
        }
        if (RouteCheckType.MINIMUM_TIME.equals(routeCheckType)) {
        }
    }
}
