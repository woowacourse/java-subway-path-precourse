package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> stationsByDistance =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> stationsByTime =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);


    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static void addVertex(String name) {
        stationsByDistance.addVertex(name);
        stationsByTime.addVertex(name);
    }

    public static void addDistance(String source, String target, int distance) {
        stationsByDistance.setEdgeWeight(stationsByDistance.addEdge(source, target), distance);
    }

    public static void addTime(String source, String target, int time) {
        stationsByTime.setEdgeWeight(stationsByTime.addEdge(source, target), time);
    }

    public static int getShortDistance(String departure, String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(stationsByDistance);
        return (int) Math.round(dijkstraShortestPath.getPathWeight(departure, arrival));
    }

    public static List<String> getRouteByDistance(String departure, String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(stationsByDistance);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }

    public static int getShortTime(String departure, String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(stationsByTime);
        return (int) Math.round(dijkstraShortestPath.getPathWeight(departure, arrival));
    }

    public static List<String> getRouteByTime(String departure, String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(stationsByTime);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }
}

