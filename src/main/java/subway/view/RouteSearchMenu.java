package subway.view;

import subway.util.StationValidator;

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

    private Scanner scanner;
    private String input;

    public RouteSearchMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startRouteSearchMenu() {
        inputMenu();
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

    private void inputMenu() {
        while (true) {
            outputRouteSearchMenu();
            this.input = scanner.nextLine();
            System.out.println();
            if (input.equals("1")) {
                requestStartStation();
            }
            if (input.equals("2")) {
                requestStartStation();
            }
            if (input.equals("B")) {
                return;
            }
        }
    }

    private void requestStartStation() {
        System.out.println(REQUEST_START);
        String startStationName = scanner.nextLine();
        System.out.println();
        if (StationValidator.haveStation(startStationName)) {
            requestArrivalStation(startStationName);
        }
    }

    private void requestArrivalStation(String startStationName) {
        System.out.println(REQUEST_ARRIVAL);
        String arrivalStationName = scanner.nextLine();
        System.out.println();
        if (StationValidator.checkVailableArrivalStation(startStationName, arrivalStationName)) {

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

    }

    private void searchShortestTimeRoute() {

    }
}
