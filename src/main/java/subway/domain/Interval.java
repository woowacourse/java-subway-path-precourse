package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class Interval {
    public static WeightedMultigraph<Station, DefaultWeightedEdge> distanceInterval = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static WeightedMultigraph<Station, DefaultWeightedEdge> timeInterval = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void registerIntervals(List<Station> stationInLine, List<Integer> distance, List<Integer> time) {
        for (Station station : stationInLine) {
            distanceInterval.addVertex(station);
            timeInterval.addVertex(station);
        }

        for (int i = 0; i < stationInLine.size() - 1; i++) {
            distanceInterval.setEdgeWeight(distanceInterval.addEdge(stationInLine.get(i), stationInLine.get(i + 1)), distance.get(i));
            timeInterval.setEdgeWeight(timeInterval.addEdge(stationInLine.get(i), stationInLine.get(i + 1)), time.get(i));
        }
    }

    public static List<Station> shortestDistancePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceInterval);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public static List<Station> shortestTimePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeInterval);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public static int getTotalDistance(List<Station> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += distanceInterval.getEdgeWeight(distanceInterval.getEdge(path.get(i), path.get(i + 1)));
        }
        return total;
    }

    public static int getTotalTime(List<Station> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += timeInterval.getEdgeWeight(timeInterval.getEdge(path.get(i), path.get(i + 1)));
        }
        return total;
    }
}
