package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ShortestDistanceService {

    private final Scanner scanner;

    public ShortestDistanceService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getShortestDistance(DijkstraShortestPath dijkstraShortestPath) {
        try {
            Station startStation = InputView.inputStartStation(scanner);
            Station arrivalStation = InputView.inputArrivalStation(scanner);
            StationRepository.validateSameStation(startStation, arrivalStation);
            List<Station> shortestPath = dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();

            for (Station station : shortestPath) {
                System.out.println(station.getName());
            }
            OutputView.printResultMessage(shortestPath, getShortestDistance(shortestPath), getTotalTime(shortestPath));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }



    private int getShortestDistance(List<Station> shortestPath) {
        int shortestDistance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station station = shortestPath.get(i);
            shortestDistance += station.getNextStationDistance(shortestPath.get(i + 1));
        }
        System.out.println(shortestDistance);
        return shortestDistance;
    }

    private int getTotalTime(List<Station> shortestPath) {
        System.out.println(shortestPath.toString());
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station station = shortestPath.get(i);
            totalTime += station.getNextStationTime(shortestPath.get(i + 1));
        }
        return totalTime;
    }

}
