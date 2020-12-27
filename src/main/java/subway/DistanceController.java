package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

public class DistanceController {
    private WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;
    private WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;
    private InputView inputView = InputView.getInstance();

    public DistanceController(WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph,
                                    WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph) {
        this.distanceGraph = distanceGraph;
        this.timeGraph = timeGraph;
    }

    public void execute() {
        try {
            Station startStation = new Station(inputView.inputStartStationToShortestDistance());
            if (!distanceGraph.containsVertex(startStation)) {
                throw new IllegalArgumentException("[ERROR] 등록되지 않은 역입니다.");
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
                throw new IllegalArgumentException("[ERROR] 등록되지 않은 역입니다.");
            }
            if (startStation.equals(endStation)) { // 위임
                throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
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
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 이어져 있지 않습니다.");
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
