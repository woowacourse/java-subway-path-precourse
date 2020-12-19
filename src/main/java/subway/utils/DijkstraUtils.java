package subway.utils;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.RouteResultDTO;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DijkstraUtils {

    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;

    private DijkstraUtils() {
    }

    public static RouteResultDTO retrieveByDistance(Station sourceName, Station targetName) {
        initGraph();
        addVertices();
        addEdgesDistance();
        GraphPath<String, DefaultWeightedEdge> graphPath = getPath(sourceName.getName(),
                targetName.getName());
        return new RouteResultDTO(
                graphPath.getVertexList(),
                graphPath.getWeight(),
                getTime(graphPath.getVertexList()));
    }

    public static RouteResultDTO retrieveByTime(Station sourceStation, Station targetStation) {
        initGraph();
        addVertices();
        addEdgesTime();
        GraphPath<String, DefaultWeightedEdge> graphPath = getPath(sourceStation.getName(),
                targetStation.getName());
        return new RouteResultDTO(
                graphPath.getVertexList(),
                getDistance(graphPath.getVertexList()),
                graphPath.getWeight());
    }

    private static Double getTime(List<String> vertexList) {
        double total = 0;
        for (int i = 0; i < vertexList.size() - 1; i++) {
            total += SectionRepository.findByName(vertexList.get(i), vertexList.get(i + 1)).getTimeWeight();
        }
        return total;
    }

    private static Double getDistance(List<String> vertexList) {
        double total = 0;
        for (int i = 0; i < vertexList.size() - 1; i++) {
            total += SectionRepository.findByName(vertexList.get(i), vertexList.get(i + 1)).getDistanceWeight();
        }
        return total;
    }

    private static GraphPath<String, DefaultWeightedEdge> getPath(String sourceName,
            String targetName) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath(
                graph);
        return dijkstraShortestPath.getPath(sourceName, targetName);
    }

    private static void addEdgesDistance() {
        SectionRepository.sections().forEach(section -> graph.setEdgeWeight(
                graph.addEdge(
                        section.getSource().getName(),
                        section.getTarget().getName()),
                section.getDistanceWeight()));
    }

    private static void addEdgesTime() {
        SectionRepository.sections().forEach(section -> graph.setEdgeWeight(
                graph.addEdge(
                        section.getSource().getName(),
                        section.getTarget().getName()),
                section.getTimeWeight()));
    }

    private static void initGraph() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    private static void addVertices() {
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
    }
}
