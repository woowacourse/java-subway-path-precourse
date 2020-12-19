package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.RouteRepository;

import java.util.List;
import java.util.Scanner;

import static resource.TextResource.*;

public class RouteShowView extends View{

    private static final String KEY_MIN_DISTANCE = "1";
    private static final String KEY_MIN_TIME = "2";
    private static final String DIVISION_LINE = "---";

    private MainView.OnBackListener onBackListener;

    public RouteShowView(Scanner scanner, MainView.OnBackListener onBackListener) {
        super(scanner);
        this.onBackListener = onBackListener;
        initMenu();

    }

    @Override
    public void startView() {
        System.out.println(HEADER_ROUTE_SHOWING);
        printMenu();
        String selection = scanner.nextLine();
        try {
            doFunction(selection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            startView();
        }
    }

    private void doFunction(String selection) {
        checkKey(selection);
        if (KEY_BACK.equals(selection)) {
            onBackListener.onBack();
            return;
        }
        doSectionManageFunction(selection);
    }

    private void doSectionManageFunction(String selection) {
        if (KEY_MIN_DISTANCE.equals(selection)) {
            printRouteMinDistance();
            onBackListener.onBack();
            return;
        }

        if (KEY_MIN_TIME.equals(selection)) {
            printRouteMinTime();
            onBackListener.onBack();
        }

    }

    private void printRouteMinDistance() {
        System.out.println(ASK_START_STATION);
        String startStation = scanner.nextLine();
        System.out.println(ASK_END_STATION);
        String endStation = scanner.nextLine();
        System.out.println(PREFIX_INFO + " " + HEADER_ROUTE_RESULT);
        System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
        int totalDistance = (int) RouteRepository.getTotalDistance(startStation, endStation);
        System.out.println(PREFIX_INFO + " " + TOTAL_DISTANCE + totalDistance + UNIT_KM);
        System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
        List<String> shortestPath = RouteRepository.getRouteMinDistance(startStation, endStation);
        for (String station : shortestPath) {
            System.out.println(PREFIX_INFO + " " + station);
        }
        System.out.println();
    }

    private void printRouteMinTime() {
        System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
        System.out.println(ASK_START_STATION);
        String startStation = scanner.nextLine();
        String endStation = scanner.nextLine();
        System.out.println(PREFIX_INFO + " " + HEADER_ROUTE_RESULT);
        System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
        int totalTime = (int) RouteRepository.getTotalTime(startStation, endStation);
        System.out.println(PREFIX_INFO + " " + TOTAL_TIME + totalTime + UNIT_MIN);
        System.out.println(PREFIX_INFO + " " + DIVISION_LINE);
        List<String> shortestPath = RouteRepository.getRouteMinTime(startStation, endStation);
        for (String station : shortestPath) {
            System.out.println(PREFIX_INFO + " " + station);
        }
        System.out.println();
    }

    private void initMenu() {
        menu.put(KEY_MIN_DISTANCE, FUNCTION_MIN_DISTANCE);
        menu.put(KEY_MIN_TIME, FUNCTION_MIN_TIME);
        menu.put(KEY_BACK, FUNCTION_BACK);
    }
}

