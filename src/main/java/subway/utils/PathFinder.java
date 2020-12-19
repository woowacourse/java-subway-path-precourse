package subway.utils;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class PathFinder {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";

    public static List<String> getShortestPath(String command, String startStation, String endStation) throws IllegalArgumentException {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = createSubwayGraph(command);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        try {
            return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        } catch (Exception exception) {
            throw new IllegalArgumentException("출발역과 도착역이 연결되어 있는 경로가 없습니다.");
        }
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> createSubwayGraph(String command) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertexes(graph);
        addEdgesAndWeights(graph, command);
        return graph;
    }

    private static void addEdgesAndWeights(WeightedMultigraph<String, DefaultWeightedEdge> graph, String command) {
        List<Line> lines = LineRepository.lines();
        if (command.equals(SHORTEST_DISTANCE)) {
            lines.forEach(line -> line.getEdgesAndWeights().forEach(edgeAndWeight -> graph.setEdgeWeight(graph.addEdge(
                    edgeAndWeight[0], edgeAndWeight[1]), Integer.parseInt(edgeAndWeight[2].replace("km", "")))
            ));
        }
        if (command.equals(SHORTEST_TIME)) {
            lines.forEach(line -> line.getEdgesAndWeights().forEach(edgeAndWeight -> graph.setEdgeWeight(graph.addEdge(
                    edgeAndWeight[0], edgeAndWeight[1]), Integer.parseInt(edgeAndWeight[3].replace("분", "")))
            ));
        }
    }

    private static void addVertexes(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<Station> stations = StationRepository.stations();
        stations.forEach(station -> graph.addVertex(station.getName()));
    }

    public static int getTotalDistance(List<String> shortestPath) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = createSubwayGraph(SHORTEST_DISTANCE);
        int totalDistance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalDistance += graph.getEdgeWeight(graph.getEdge(shortestPath.get(i), shortestPath.get(i + 1)));
        }
        return totalDistance;
    }

    public static int getTotalTime(List<String> shortestPath) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = createSubwayGraph(SHORTEST_TIME);
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalTime += graph.getEdgeWeight(graph.getEdge(shortestPath.get(i), shortestPath.get(i + 1)));
        }
        return totalTime;
    }
}
