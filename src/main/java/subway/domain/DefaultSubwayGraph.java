package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.graph.*;

public class DefaultSubwayGraph {

    private static DefaultSections defaultSections;
    private static Graph<Object, DefaultWeightedEdge> graph = new SimpleGraph<Object, DefaultWeightedEdge>(
        DefaultWeightedEdge.class);

    public DefaultSubwayGraph() {
        graph = createStringGraph();
        defaultSections = new DefaultSections();
    }

    private static Graph<Object, DefaultWeightedEdge> createStringGraph() {
        Graph<Object, DefaultWeightedEdge> graph = new SimpleGraph<Object, DefaultWeightedEdge>(
            DefaultWeightedEdge.class);
        addDefaultStations();
        addDefaultEdges();
        return graph;
    }

    public static void addDefaultStations() {
        DefaultStations defaultStations = new DefaultStations();
        for (String stationName : defaultStations.getDefaultNames()) {
            graph.addVertex(stationName);
        }
    }

    public static void addDefaultEdges() {
        DefaultSections defaultSections = new DefaultSections();

        for (Section section : defaultSections.getSections()) {
            DefaultWeightedEdge e = graph
                .addEdge(section.getDepartureStation(), section.getArrivalStation());
//            graph.setEdgeWeight(e, section.getCost().getDistanceCost());
        }
    }
}
