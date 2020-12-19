package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.graph.*;

public class DefaultSubwayGraph {

    private static DefaultSections defaultSections;
    private static Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

    public DefaultSubwayGraph() {
        graph = createStringGraph();
        defaultSections = new DefaultSections();
    }

    private static Graph<String, DefaultEdge> createStringGraph()
    {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
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
            DefaultEdge e = graph
                .addEdge(section.getDepartureStation(), section.getArrivalStation());
            graph.setEdgeWeight(e, section.getCost().getDistanceCost());
        }
    }
}
