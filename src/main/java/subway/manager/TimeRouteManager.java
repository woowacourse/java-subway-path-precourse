package subway.manager;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.Constants;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

public class TimeRouteManager {
    private WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;
    private WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;
    private InputView inputView = InputView.getInstance();

    public TimeRouteManager(WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph,
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

    private void calculateShortestDistance(Station startStation, Station endStation) {
        List<Station> shortestPath = getShortestTimePath(startStation, endStation);
        int distance = getTotalDistanceWhenShortestTimePath(shortestPath);
        int time = getTotalTimeWhenShortestTimePath(shortestPath);
        OutputView.printTotalDistanceAndTime(distance, time);
        OutputView.printRouteList(shortestPath);
    }

    public List<Station> getShortestTimePath(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public int getTotalDistanceWhenShortestTimePath(List<Station> shortestTimePath) {
        int totalDistance = 0;
        for (int i=0; i<shortestTimePath.size() - 1; i++) {
            Station startStation = shortestTimePath.get(i);
            Station endStation = shortestTimePath.get(i + 1);
            totalDistance += (int) distanceGraph.getEdgeWeight(distanceGraph.getEdge(startStation, endStation));
        }
        return totalDistance;
    }

    public int getTotalTimeWhenShortestTimePath(List<Station> shortestTimePath) {
        int totalTime = 0;
        for (int i=0; i<shortestTimePath.size() - 1; i++) {
            Station startStation = shortestTimePath.get(i);
            Station endStation = shortestTimePath.get(i + 1);
            totalTime += (int) timeGraph.getEdgeWeight(timeGraph.getEdge(startStation, endStation));
        }
        return totalTime;
    }

}
