package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.RoutePage;
import utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class RouteController {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String MINIMUM_TIME = "2";
    private static final String BACK = "B";
    private static final RoutePage ROUTE_PAGE = new RoutePage();

    public void startRoutePage(Scanner scanner) {
        ROUTE_PAGE.printRoutePage();
        forkPath(InputUtils.inputString(scanner), scanner);
    }

    public void forkPath(String item, Scanner scanner) {
        if (SHORTEST_DISTANCE.equals(item)) {
            startSelectRoute(scanner, SHORTEST_DISTANCE);
            return;
        }

        if (MINIMUM_TIME.equals(item)) {
            startSelectRoute(scanner, MINIMUM_TIME);
            return;
        }
        if (BACK.equals(item)) {
            MainController.startMainPage(scanner);
            return;
        }
        ROUTE_PAGE.printWrongItemError();
        startRoutePage(scanner);
    }

    public void startSelectRoute(Scanner scanner, String item) {
        ROUTE_PAGE.printDepartureStationPage();
        String departure = InputUtils.inputString(scanner);
        if (isExistStation(departure, scanner)) {
            ROUTE_PAGE.printArrivalStationPage();
            String arrival = InputUtils.inputString(scanner);
            if (isSameStation(departure, arrival, scanner)) {
                selectRoute(departure, arrival, item, scanner);
                MainController.startMainPage(scanner);
            }
        }
    }

    public void selectRoute(String departure, String arrival, String item, Scanner scanner) {
        if (SHORTEST_DISTANCE.equals(item)) {
            selectShortDistance(departure, arrival);
        }
        if (MINIMUM_TIME.equals(item)) {
            selectShortTime(departure, arrival);
        }
    }

    public void selectShortDistance(String departure, String arrival) {
        int distance = LineRepository.getShortDistance(departure, arrival);
        int time = LineRepository.getShortTime(departure, arrival);
        List<String> shortestPath = LineRepository.getRouteByDistance(departure, arrival);
        ROUTE_PAGE.printSelectResult(distance, time, shortestPath);
    }

    public void selectShortTime(String departure, String arrival) {
        int distance = LineRepository.getShortTime(departure, arrival);
        int time = LineRepository.getShortTime(departure, arrival);
        List<String> shortestPath = LineRepository.getRouteByTime(departure, arrival);
        ROUTE_PAGE.printSelectResult(distance, time, shortestPath);
    }


    public boolean isExistStation(String name, Scanner scanner) {
        if (StationRepository.isExistStationName(name)) {
            ROUTE_PAGE.printNullStationError();
            startRoutePage(scanner);
            return false;
        }
        return true;
    }

    public boolean isSameStation(String departure, String arrival, Scanner scanner) {
        if (isExistStation(arrival, scanner)) {
            if (departure.equals(arrival)) {
                ROUTE_PAGE.printSameStationError();
                startRoutePage(scanner);
                return false;
            }
            return true;
        }
        return false;
    }
}
