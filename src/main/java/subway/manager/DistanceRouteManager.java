package subway.manager;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.Constants;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

public class DistanceRouteManager {
    private WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;
    private WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;
    private InputView inputView = InputView.getInstance();

    public DistanceRouteManager(WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph,
                                WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph) {
        this.distanceGraph = distanceGraph;
        this.timeGraph = timeGraph;
    }

    public void execute() {
        try {
            Station startStation = new Station(inputView.inputStartStationToShortestDistance());
            if (!distanceGraph.containsVertex(startStation)) {
                throw new IllegalArgumentException(Constants.ERROR_NOT_ENROLLMENT_STATION);
            }
            selectEndStation(startStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute();
        }
    }

    private void selectEndStation(Station startStation) {
        try {
            Station endStation = new Station(inputView.inputEndStationToShortestDistance());
            if (!distanceGraph.containsVertex(endStation)) {
                throw new IllegalArgumentException(Constants.ERROR_NOT_ENROLLMENT_STATION);
            }
            if (startStation.equals(endStation)) {
                throw new IllegalArgumentException(Constants.ERROR_START_END_NOT_EQUAL);
            }
            calculateShortestDistance(startStation, endStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectEndStation(startStation);
        }
    }

    private void calculateShortestDistance(Station startStation, Station endStation)
                                                        throws IllegalArgumentException {
        List<Station> shortestPath = getShortestDistancePath(startStation, endStation);
        int distance = getTotalDistanceWhenShortestDistancePath(shortestPath);
        int time = getTotalTimeWhenShortestDistancePath(shortestPath);
        OutputView.printTotalDistanceAndTime(distance, time);
        OutputView.printRouteList(shortestPath);
    }

    private List<Station> getShortestDistancePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        if (dijkstraShortestPath.getPath(start, end) == null) {
            throw new IllegalArgumentException(Constants.ERROR_START_END_NOT_LINKED);
        }
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    private int getTotalDistanceWhenShortestDistancePath(List<Station> shortestDistancePath) {
        int totalDistance = 0;
        for (int i=0; i<shortestDistancePath.size() - 1; i++) {
            Station startStation = shortestDistancePath.get(i);
            Station endStation = shortestDistancePath.get(i + 1);
            totalDistance += (int) distanceGraph.getEdgeWeight(distanceGraph.getEdge(startStation, endStation));
        }
        return totalDistance;
    }

    private int getTotalTimeWhenShortestDistancePath(List<Station> shortestDistancePath) {
        int totalTime = 0;
        for (int i=0; i<shortestDistancePath.size() - 1; i++) {
            Station startStation = shortestDistancePath.get(i);
            Station endStation = shortestDistancePath.get(i + 1);
            totalTime += (int) timeGraph.getEdgeWeight(timeGraph.getEdge(startStation, endStation));
        }
        return totalTime;
    }

}
