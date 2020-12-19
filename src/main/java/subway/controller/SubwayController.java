package subway.controller;

import subway.domain.*;
import subway.view.Presenter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubwayController {
    private static final String MENU_ONE = "1";
    private static final String MENU_TWO = "2";
    private static final String MENU_BACK = "B";
    private static final String MENU_QUIT = "Q";

    private final SubwayPath subwayPath;
    private final Scanner scanner;
    private final Presenter presenter;

    public SubwayController(SubwayPath subwayPath, Scanner scanner, Presenter presenter) {
        this.subwayPath = subwayPath;
        this.scanner = scanner;
        this.presenter = presenter;
    }

    public void run() {
        initPrimary();
        do {
            presenter.mainInfo();
        } while (choiceFunction(scanner.nextLine()));
    }

    // false -> loop break;
    private boolean choiceFunction(String input) {
        if (input.equals(MENU_QUIT)) {
            return false;
        }
        if (input.equals(MENU_ONE)) {
            presenter.pathInfo();
            return selectPath(scanner.nextLine());
        }
        presenter.wrongInput();
        return true;
    }

    // false -> loop break;
    private boolean selectPath(String input) {
        if (input.equals(MENU_BACK)) {
            return false;
        }
        if (input.equals(MENU_ONE) || input.equals(MENU_TWO)) {
            return !getFromAndTo(input);
        }
        presenter.wrongInput();
        return true;
    }

    private boolean getFromAndTo(String input) {
        String from = getStartingStation();
        if (from.equals("")) {
            return false;
        }
        String to = getDestinationStation(from);
        if (to.equals("")) {
            return false;
        }
        return printPath(input, from, to);
    }

    private boolean printPath(String input, String from, String to) {
        List<String> path = null;
        if (input.equals(MENU_ONE)) {
            path = subwayPath.getDistancePath(from, to);
        }
        if (input.equals(MENU_TWO)) {
            path = subwayPath.getTimePath(from, to);
        }
        if (path == null || path.size() == 0) {
            presenter.noPath();
            return false;
        }
        presenter.resultInfo(getTotalDistance(path), getTotalTime(path), path);
        return true;
    }

    private int getTotalDistance(List<String> path) {
        if (path == null) {
            return 0;
        }
        int distance = 0;
        for (int i = 1; i < path.size(); i++) {
            distance += EdgeRepository.getEdgeByFromAndTo(path.get(i - 1), path.get(i)).getDistance();
        }
        return distance;
    }

    private int getTotalTime(List<String> path) {
        if (path == null) {
            return 0;
        }
        int time = 0;
        for (int i = 1; i < path.size(); i++) {
            time += EdgeRepository.getEdgeByFromAndTo(path.get(i - 1), path.get(i)).getTime();
        }
        return time;
    }

    private String getStartingStation() {
        presenter.inputStartingStation();
        String station = scanner.nextLine();
        if (!isInStations(station)) {
            presenter.noStation();
            return "";
        }
        return station;
    }

    private String getDestinationStation(String from) {
        presenter.inputDestinationStation();
        String station = scanner.nextLine();
        if (!isInStations(station)) {
            presenter.noStation();
            return "";
        }
        if (from.equals(station)) {
            presenter.sameStation();
            return "";
        }
        return station;
    }

    private boolean isInStations(String name) {
        return StationRepository.stations().stream().anyMatch(station -> station.getName().equals(name));
    }


    public void initPrimary() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(name -> StationRepository.addStation(new Station(name)));
        EdgeRepository.addEdge(new Edge("교대역", "강남역", 2, 3));
        EdgeRepository.addEdge(new Edge("강남역", "역삼역", 2, 3));
        EdgeRepository.addEdge(new Edge("교대역", "남부터미널역", 3, 2));
        EdgeRepository.addEdge(new Edge("남부터미널역", "양재역", 6, 5));
        EdgeRepository.addEdge(new Edge("양재역", "매봉역", 1, 1));
        EdgeRepository.addEdge(new Edge("강남역", "양재역", 2, 8));
        EdgeRepository.addEdge(new Edge("양재역", "양재시민의숲역", 10, 3));
    }
}
