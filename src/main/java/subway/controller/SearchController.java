package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;
import subway.domain.validator.SearchValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class SearchController {
    private final Scanner scanner;
    private final DijkstraShortestPath dijkstraPathByDistance;
    private final DijkstraShortestPath dijkstraPathByTime;

    public SearchController(Scanner scanner) {
        this.scanner = scanner;
        dijkstraPathByDistance = new DijkstraShortestPath(SearchGraph.getGraphByDistance());
        dijkstraPathByTime = new DijkstraShortestPath(SearchGraph.getGraphByTime());
    }

    public void searchByDistance() {
        Station from = getDeparture();
        Station to = getArrival();
        SearchValidator.checkTwoStationsAreDifferent(from, to);
        List<Station> shortest = dijkstraPathByDistance.getPath(from, to).getVertexList();
        printResult(shortest);
    }

    public void searchByTime() {
        Station from = getDeparture();
        Station to = getArrival();
        SearchValidator.checkTwoStationsAreDifferent(from, to);
        List<Station> shortest = dijkstraPathByTime.getPath(from, to).getVertexList();
        printResult(shortest);
    }

    private void printResult(List<Station> path) {
        int takenDistance = getSumOfWeights(path, dijkstraPathByDistance);
        int takenTime = getSumOfWeights(path, dijkstraPathByTime);
        OutputView.printSearchResult(path, takenDistance, takenTime);
    }

    private int getSumOfWeights(List<Station> path, final DijkstraShortestPath dijkstraShortestPath) {
        int sum = 0;
        for (int index = 0; index < path.size() - 1; index++) {
            Station from = path.get(index);
            Station to = path.get(index + 1);
            sum += dijkstraShortestPath.getPath(from, to).getWeight();
        }
        return sum;
    }

    private Station getDeparture() {
        try {
            String name = InputView.getDepartureStation(scanner);
            return getStationByName(name);
        } catch (Exception e) {
            OutputView.printError(e);
            return getDeparture();
        }
    }

    private Station getArrival() {
        try {
            String name = InputView.getArrivalStation(scanner);
            return getStationByName(name);
        } catch (Exception e) {
            OutputView.printError(e);
            return getArrival();
        }
    }

    private Station getStationByName(String name) {
        return StationRepository.getStation(name);
    }
}
