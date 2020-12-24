package subway.domain;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DefaultSubwayGraph {

    private static DefaultStations defaultStations;
    private static DefaultSections defaultSections;
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;

    public DefaultSubwayGraph() {
        defaultStations = new DefaultStations();
        defaultSections = new DefaultSections();
        graph = createStringGraph();
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> createStringGraph() {
        graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        addDefaultStations();
        addDefaultDistanceEdges();
        return graph;
    }

    public static void addDefaultStations() {
        for (String stationName : defaultStations.getDefaultNames()) {
            graph.addVertex(stationName);
        }
    }

    public static void addDefaultDistanceEdges() {
        for (Section section : defaultSections.getSections()) {
            graph.setEdgeWeight(
                graph.addEdge(section.getDepartureStation(), section.getArrivalStation()),
                section.getCost().distanceCost);
        }
    }

    public List<String> getDijkstraDistanceShortestPath(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation)
            .getVertexList();
        return shortestPath;
    }
}
