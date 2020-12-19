package subway.service;

import java.util.Scanner;

import static subway.domain.MenuType.*;

public class SearchPathService extends InputService {

    public boolean selectSearchPathMenu(Scanner scanner, String menu) {
        if (SEARCH_SHORTEST_PATH.isKeyEquals(menu)) {
            return searchShortestPath(scanner);
        }
        if (SEARCH_SHORTEST_TIME.isKeyEquals(menu)) {
            return searchShortestTime(scanner);
        }
        if (BACK.isKeyEquals(menu)) {
            return true;
        }
        return false;
    }

    private boolean searchShortestPath(Scanner scanner) {
        try {
            String startStationName = inputStartStationName(scanner);
            String endStationName = inputEndStationName(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean searchShortestTime(Scanner scanner) {
        try {
            String startStationName = inputStartStationName(scanner);
            String endStationName = inputEndStationName(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}