package subway.view;

import subway.util.CalculatorRoute;
import subway.util.DistanceRouteSearch;
import subway.util.validator.MenuValidator;
import subway.util.validator.StationValidator;
import subway.util.TimeRouteSearch;

import java.util.List;
import java.util.Scanner;

public class RouteSearchMenu {
    private final String ROUTE_SEARCH_TITLE = "## 경로 기준";
    private final String MENU1 = "1. 최단 거리";
    private final String MENU2 = "2. 최소 시간";
    private final String BACK = "B. 돌아가기";
    private final String ENTER = "\n";
    private final String CHOICE_MENU = "## 원하는 기능을 선택하세요.";
    private final String REQUEST_START = "## 출발역을 입력하세요.";
    private final String REQUEST_ARRIVAL = "## 도착역을 입력하세요.";
    private final String LINE = "---";
    private final String INFO = "[ INFO ] ";

    private Scanner scanner;
    private String input;
    private String startStationName;
    private String arrivalStationName;

    public RouteSearchMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startRouteSearchMenu() {
        inputMenu();
    }

    private void inputMenu() {
        while (true) {
            outputRouteSearchMenu();
            this.input = scanner.nextLine();
            System.out.println();
            MenuValidator.isVailableRouteSearchMenu(input);
            if (input.equals("1") || input.equals("2")) {
                requestStartStation();
            }
            if (input.equals("B")) {
                return;
            }
        }
    }

    private void requestStartStation() {
        System.out.println(REQUEST_START);
        this.startStationName = scanner.nextLine();
        System.out.println();
        if (StationValidator.haveStation(startStationName)) {
            requestArrivalStation();
        }
    }

    private void requestArrivalStation() {
        System.out.println(REQUEST_ARRIVAL);
        this.arrivalStationName = scanner.nextLine();
        System.out.println();
        if (StationValidator.checkVailableArrivalStation(startStationName, arrivalStationName)) {
            checkSearchMethod();
        }
    }

    private void checkSearchMethod() {
        if (input.equals("1")) {
            searchShortestDistanceRoute();
        }
        if (input.equals("2")) {
            searchShortestTimeRoute();
        }
    }

    private void searchShortestDistanceRoute() {
        List<String> list = DistanceRouteSearch.getShortestRoute(startStationName, arrivalStationName);
        int time = CalculatorRoute.calculatorRouteTime(list);
        int distance = CalculatorRoute.calculatorRoutDistance(list);
        System.out.println("## 조회결과");
        System.out.println(LINE);
        System.out.println("총 거리: " + distance + "km");
        System.out.println("총 소요 시간 : " + time + "분");
        System.out.println(LINE);
        for (String station : list) {
            System.out.println(INFO + station);
        }
        System.out.println();
    }

    private void searchShortestTimeRoute() {
        List<String> list = TimeRouteSearch.getShortestRoute(startStationName, arrivalStationName);
        int time = CalculatorRoute.calculatorRouteTime(list);
        int distance = CalculatorRoute.calculatorRoutDistance(list);
        System.out.println("## 조회결과");
        System.out.println(LINE);
        System.out.println("총 거리: " + distance + "km");
        System.out.println("총 소요 시간 : " + time + "분");
        System.out.println(LINE);
        for (String station : list) {
            System.out.println(INFO + station);
        }
        System.out.println();
    }

    private void outputRouteSearchMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(ROUTE_SEARCH_TITLE).append(ENTER)
                .append(MENU1).append(ENTER)
                .append(MENU2).append(ENTER)
                .append(BACK).append(ENTER)
                .append(ENTER)
                .append(CHOICE_MENU);
        System.out.println(sb);
    }
}
