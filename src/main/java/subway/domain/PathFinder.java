package subway.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathFinder {

    public static List<String> findMinDistancePath(Station departure, Station arrival) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = initializeGraphForDistance();
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortesPath =
                new DijkstraShortestPath<String, DefaultWeightedEdge>(graph);
        GraphPath<String, DefaultWeightedEdge> path =
                dijkstraShortesPath.getPath(departure.getName(), arrival.getName());
        if (path == null) {
            return null;
        }
        return path.getVertexList();
    }

    public static List<String> findMinTimePath(Station departure, Station arrival) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = initializeGraphForTime();
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortesPath =
                new DijkstraShortestPath<String, DefaultWeightedEdge>(graph);
        GraphPath<String, DefaultWeightedEdge> path =
                dijkstraShortesPath.getPath(departure.getName(), arrival.getName());
        if (path == null) {
            return null;
        }
        return path.getVertexList();
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> initializeGraphForDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph =
                new WeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        List<String> stationNames = StationRepository.stations().stream()
                .map(station -> station.getName()).collect(Collectors.toList());
        List<Line> lines = LineRepository.lines();
        initializeStations(stationNames, graph);
        initializeLinesForDistance(lines, graph);
        return graph;
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> initializeGraphForTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph =
                new WeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        List<String> stationNames = StationRepository.stations().stream()
                .map(station -> station.getName()).collect(Collectors.toList());
        List<Line> lines = LineRepository.lines();
        initializeStations(stationNames, graph);
        initializeLinesForTime(lines, graph);
        return graph;
    }

    private static void initializeStations(List<String> stationNames,
            WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        for (String stationName : stationNames) {
            graph.addVertex(stationName);
        }
    }

    private static void initializeLinesForDistance(List<Line> lines,
            WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            List<Integer> distances = line.getDistances();
            for (int index = 0; index < distances.size(); index++) {
                String firstStation = stations.get(index).getName();
                String secondStation = stations.get(index + 1).getName();
                graph.setEdgeWeight(graph.addEdge(firstStation, secondStation),
                        distances.get(index));
            }
        }
    }

    private static void initializeLinesForTime(List<Line> lines,
            WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            List<Integer> times = line.getTimes();
            for (int index = 0; index < times.size(); index++) {
                String firstStation = stations.get(index).getName();
                String secondStation = stations.get(index + 1).getName();
                graph.setEdgeWeight(graph.addEdge(firstStation, secondStation), times.get(index));
            }
        }
    }
}
