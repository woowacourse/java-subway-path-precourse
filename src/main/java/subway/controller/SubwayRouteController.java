package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.SubwayInitializer;
import subway.domain.StationRepository;
import subway.utils.InputValidation;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayRouteController {
    private static final String SHORTEST_DIST = "1";
    private static final String MIN_TIME = "2";
    private static final String BACK = "B";
    private static final String ARRIVAL = "출발";
    private static final String DEPARTURE = "도착";
    private static final String DISTANCE = "거리";
    private static final String TIME = "시간";
    private static final String ERROR = "\n[ERROR] ";
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = SubwayInitializer.initGraph(DISTANCE);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = SubwayInitializer.initGraph(TIME);

    public static final void logic(Scanner scanner) {
        OutputView.printRouteMainMenu();
        try {
            String functionNumber = InputValidation.isValidOfInputRouteMenu(InputView.inputFunctionNumber(scanner));
            if (functionNumber.equals(BACK)) return;
            MenuConnectByCommand(scanner, functionNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static final void MenuConnectByCommand(Scanner scanner, String command) {
        if (command.equals(SHORTEST_DIST)) {
            lookupShortestPath(scanner, DISTANCE);
            return;
        }

        if (command.equals(MIN_TIME)) {
            lookupShortestPath(scanner, TIME);
            return;
        }
    }

    private static final void lookupShortestPath(Scanner scanner, String type) {
        String arrivalStation = InputView.inputStation(scanner, ARRIVAL);
        String departureStation = InputView.inputStation(scanner, DEPARTURE);

        try {
            isValid(arrivalStation, departureStation);
            isExist(arrivalStation, departureStation);
            if (type == DISTANCE) {
                calculatePathOfShortestDistance(arrivalStation, departureStation);
            }
            if (type == TIME) {
                calculatePathOfShortestTime(arrivalStation, departureStation);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private static final void isValid(String arrival, String departure) {
        if (arrival.equals(departure)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
        }
    }

    private static final void isExist(String arrival, String departure) {
        if (!StationRepository.isExist(arrival) ||
                !StationRepository.isExist(departure)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역이 포함되어 있습니다.");
        }
    }

    private static final void calculatePathOfShortestDistance(String arrival, String departure) {
        final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(arrival, departure).getVertexList();
        double distance = dijkstraShortestPath.getPathWeight(arrival, departure);
        double time = summation(shortestPath, TIME);
        OutputView.printResults(shortestPath, distance, time);
    }

    private static final void calculatePathOfShortestTime(String arrival, String departure) {
        final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(arrival, departure).getVertexList();
        double distance = summation(shortestPath, DISTANCE);
        double time = dijkstraShortestPath.getPathWeight(arrival, departure);
        OutputView.printResults(shortestPath, distance, time);
    }

    /**
     * 최단 거리로 경로를 조회하는 경우에는 해당 경로에 드는 총 소요 시간을 계산하기 위함
     * 최소 시간으로 경로를 조작하는 경우에는 해당 경로에 드는 총 거리를 계산하기 위함
     *
     * @param shortestPath
     * @return totalValue
     */
    private static double summation(List<String> shortestPath, String type) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = SubwayInitializer.initGraph(type);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        double totalValue = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalValue += dijkstraShortestPath.getPathWeight(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return totalValue;
    }

}
