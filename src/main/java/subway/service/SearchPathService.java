package subway.service;

import org.jgrapht.GraphPath;
import subway.domain.LineStationRepository;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.domain.MenuType.*;
import static subway.domain.StationRepository.findStationByName;
import static subway.view.OutputView.printResult;

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
            calculationShortestPath(startStationName, endStationName);
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
            calculationShortestTime(startStationName, endStationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void calculationShortestPath(String startStationName, String endStationName) {
        findStationByName(startStationName);
        findStationByName(endStationName);
        GraphPath shortestPath = LineStationRepository.findShortestPath(startStationName, endStationName);
        printResult(shortestPath);
    }

    private void calculationShortestTime(String startStationName, String endStationName) {
        findStationByName(startStationName);
        findStationByName(endStationName);
        GraphPath shortestPath = LineStationRepository.findShortestTime(startStationName, endStationName);
        printResult(shortestPath);
    }
}