package subway.util;

import subway.domain.*;
import subway.exception.ExceptionManager;
import subway.view.FindPathView;
import subway.view.Input;
import subway.view.MainView;

import java.util.List;
import java.util.Scanner;

public class GraphInitializer {
    public static final String DISTANCE = "km";
    public static final String TIME = "분";
    public static final String RESULT = "## 조회 결과";
    public static final String DIVIDE_LINE = "[INFO] ---";
    public static final String RESULT_DISTANCE = "[INFO] 총 거리: ";
    public static final String RESULT_TIME = "[INFO] 총 소요 시간: ";
    public static final String INFO_FORMAT = "[INFO] ";
    public static final String ASK_SOURCE = "## 출발역을 입력하세요.";
    public static final String ASK_DESTINATION = "## 도착역을 입력하세요.";

    public GraphInitializer(String command, Scanner scanner) {
        GraphRepository graphRepository = new GraphRepository();
        for (Station station : StationRepository.stations()) {
            graphRepository.addVertex(station.getName());
        }
        if (command.equals("1")) {
            byDistance(graphRepository);
        }
        if (command.equals("2")) {
            byTime(graphRepository);
        }
        GraphGenerator(graphRepository, scanner);
    }

    public void GraphGenerator(GraphRepository graphRepository, Scanner scanner) {
        String[] stations = getStations(scanner);
        List<String> shortestPath = graphRepository.calPath(stations[0], stations[1]);
        try {
            ExceptionManager.isPathExist(shortestPath);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            FindPathView.printFindPathView(scanner);
        }
        printResult(shortestPath);
        printShortestPath(shortestPath);
        MainView.printMainView(scanner);
    }

    public void byDistance(GraphRepository graphRepository) {
        for (Edge edge : EdgeRepository.edges()) {
            graphRepository.setWeight(edge.getStation1(), edge.getStation2(), edge.getDistance());
        }
    }

    public void byTime(GraphRepository graphRepository) {
        for (Edge edge : EdgeRepository.edges()) {
            graphRepository.setWeight(edge.getStation1(), edge.getStation2(), edge.getTime());
        }
    }

    public String[] getStations(Scanner scanner) {
        String[] stations = new String[2];
        stations[0] = Input.getSourceStation(scanner);
        stations[1] = Input.getDestinationStation(scanner);
        try {
            ExceptionManager.isSameStations(stations[0], stations[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            FindPathView.printFindPathView(scanner);
        }
        return stations;
    }

    public void printResult(List<String> shortestPath) {
        System.out.println(RESULT);
        System.out.println(DIVIDE_LINE);
        System.out.println(RESULT_DISTANCE + calDistanceOrTime(shortestPath, "distance") + DISTANCE);
        System.out.println(RESULT_TIME + calDistanceOrTime(shortestPath, "time") + TIME);
        System.out.println(DIVIDE_LINE);
    }

    public void printShortestPath(List<String> ShortestPath) {
        for (String path : ShortestPath) {
            System.out.println(INFO_FORMAT + path);
        }
        System.out.print("\n");
    }

    public int calDistanceOrTime(List<String> shortestPath, String type) {
        int n = shortestPath.size();
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += getValue(shortestPath, type, i);
        }
        return sum;
    }

    public int getValue(List<String> shortestPath, String type, int i) {
        int val = 0;
        for (Edge edge : EdgeRepository.edges()) {
            val += getNumber(shortestPath, edge, type, i);
        }
        return val;
    }

    public int getNumber(List<String> shortestPath, Edge edge, String type, int i) {
        int val = 0;
        if (shortestPath.get(i).equals(edge.getStation1()) && shortestPath.get(i + 1).equals(edge.getStation2())) {
            val = edge.getDistanceOrTime(type);
        }
        if (shortestPath.get(i).equals(edge.getStation2()) && shortestPath.get(i + 1).equals(edge.getStation1())) {
            val = edge.getDistanceOrTime(type);
        }
        return val;
    }
}
