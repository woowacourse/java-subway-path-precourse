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
            lookupShortestDistancePath(scanner);
            return;
        }
        if (command.equals(MIN_TIME)) {
            lookupMinTimePath(scanner);
            return;
        }
    }

    private static final void lookupShortestDistancePath(Scanner scanner) {
        String arrivalStation = InputView.inputStation(scanner, ARRIVAL);
        String departureStation = InputView.inputStation(scanner, DEPARTURE);
        if (!isValid(arrivalStation, departureStation)) {
            System.out.println("[ERROR] 출발역과 도착역이 같습니다.");
            return;
        }

        if (!StationRepository.isExist(arrivalStation) ||
                !StationRepository.isExist(departureStation)) {
            System.out.println("[ERROR] 존재하지 않는 역이 포함되어 있습니다.");
            return;
        }

        calculatePath(arrivalStation, departureStation, DISTANCE);
    }

    private static final boolean isValid(String arrival, String departure) {
        return !arrival.equals(departure);
    }

    private static final void lookupMinTimePath(Scanner scanner) {

    }

    private static final void calculatePath(String arrival, String departure, String type) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = SubwayInitializer.initGraph(type);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(arrival, departure).getVertexList();
        double distance = dijkstraShortestPath.getPathWeight(arrival,departure);
        OutputView.printResults(shortestPath, distance);
    }

}
