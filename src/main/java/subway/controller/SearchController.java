package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.DistanceGraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TakeTimeGraph;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SearchController {
    private final Scanner scanner;

    public SearchController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void searchByDistance() {
        Station from = getDeparture();
        Station to = getArrival();
        List<Station> shortest = getShortestPath(from, to, DistanceGraph.getGraph());
        printResult(shortest);
    }

    public void searchByTime() {
        Station from = getDeparture();
        Station to = getArrival();
        List<Station> shortest = getShortestPath(from, to, TakeTimeGraph.getGraph());
        printResult(shortest);
    }

    private List<Station> getShortestPath(Station from, Station to, final WeightedMultigraph graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }

    private void printResult(List<Station> path) {
        int takenDistance = getTakenDistance(path);
        int takenTime = getTakenTime(path);
        OutputView.printSearchResult(path, takenDistance, takenTime);
    }

    private int getTakenDistance(List<Station> path) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(DistanceGraph.getGraph());
        int takenDistance = 0;
        for (int index = 0; index < path.size() - 1; index++) {
            Station from = path.get(index);
            Station to = path.get(index + 1);
            takenDistance += dijkstraShortestPath.getPath(from, to).getWeight();
        }
        return takenDistance;
    }

    private int getTakenTime(List<Station> path) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(TakeTimeGraph.getGraph());

        int takenTime = 0;
        for (int index = 0; index < path.size() - 1; index++) {
            Station from = path.get(index);
            Station to = path.get(index + 1);
            takenTime += dijkstraShortestPath.getPath(from, to).getWeight();
        }
        return takenTime;
    }

    private Station getDeparture() {
        String name = InputView.getDepartureStation(scanner);
        return getStationByName(name);
    }

    private Station getArrival() {
        String name = InputView.getDepartureStation(scanner);
        return getStationByName(name);
    }

    private Station getStationByName(String name) {
        return StationRepository.getStation(name);
    }
}
