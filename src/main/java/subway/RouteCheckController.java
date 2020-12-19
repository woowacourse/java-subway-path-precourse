package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RouteCheckController {
    private static final String SAME_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";

    private final Scanner scanner;

    public RouteCheckController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void selectShortestDistance(DijkstraShortestPath dijkstraShortestPath) {
        try {
            Station startStation = InputView.inputStartStation(scanner);
            Station arrivalStation = InputView.inputArrivalStation(scanner);
            validateSameStation(startStation, arrivalStation);
            List<Station> shortestPath = dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();
            OutputView.printResultMessage(shortestPath, getShortestDistance(shortestPath), getTotalTime(shortestPath));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSameStation(Station startStation, Station arrivalStation) {
        if (startStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }

    private int getShortestDistance(List<Station> shortestPath) {
        int shortestDistance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station station = shortestPath.get(i);
            shortestDistance += station.getNextStationDistance(shortestPath.get(i + 1));
        }
        return shortestDistance;
    }

    private int getTotalTime(List<Station> shortestPath) {
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station station = shortestPath.get(i);
            totalTime += station.getNextStationTime(shortestPath.get(i + 1));
        }
        return totalTime;
    }
}
