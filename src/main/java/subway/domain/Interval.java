package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class Interval {
    WeightedMultigraph<Station, DefaultWeightedEdge> distanceInterval = new WeightedMultigraph(DefaultWeightedEdge.class);
    WeightedMultigraph<Station, DefaultWeightedEdge> timeInterval = new WeightedMultigraph(DefaultWeightedEdge.class);

    public Interval(List<Station> stationInLine, int[] distance, int[] time) {
        for (Station station : stationInLine) {
            distanceInterval.addVertex(station);
            timeInterval.addVertex(station);
        }

        for (int i = 0; i < stationInLine.size() - 1; i++) {
            distanceInterval.setEdgeWeight(distanceInterval.addEdge(stationInLine.get(i), stationInLine.get(i + 1)), distance[i]);
            timeInterval.setEdgeWeight(timeInterval.addEdge(stationInLine.get(i), stationInLine.get(i + 1)), time[i]);
        }
    }

    public List<Station> shortestDistancePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceInterval);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public int getTotalDistance(List<Station> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += distanceInterval.getEdgeWeight(distanceInterval.getEdge(path.get(i), path.get(i + 1)));
        }
        return total;
    }

    public int getTotalTime(List<Station> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += timeInterval.getEdgeWeight(timeInterval.getEdge(path.get(i), path.get(i + 1)));
        }
        return total;
    }
}
