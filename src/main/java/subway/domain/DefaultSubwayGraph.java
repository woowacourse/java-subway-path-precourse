package subway.domain;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class DefaultSubwayGraph {

    private static DefaultDirectedWeightedGraph subwayMap;
    private static DefaultSections defaultSections;

    public static void DefaultSubwayGraph() {
        subwayMap = new DefaultDirectedWeightedGraph<Station, DefaultWeightedEdge>(
            DefaultWeightedEdge.class);
        defaultSections = new DefaultSections();
        addDefaultStations();
        addDefaultEdges();
    }

    public static void addDefaultStations() {
        for (Station station : DefaultStations.getDefaultStations()) {
            subwayMap.addVertex(station.getName());
        }
    }

    public static void addDefaultEdges() {
        for (Section section : DefaultSections.getSections()) {
            DefaultWeightedEdge e = subwayMap.addEdge(section.)
        }
    }
}
