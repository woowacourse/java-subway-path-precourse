package subway.domain;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class DefaultSubwayGraph {

    private static DefaultDirectedWeightedGraph subwayMap;

    public DefaultSubwayGraph() {
        subwayMap = new DefaultDirectedWeightedGraph<Station, DefaultWeightedEdge>(
            DefaultWeightedEdge.class);
        addDefaultStations();
        addDefaultEdges();
    }

    private void addDefaultStations() {
        for (Station station : DefaultStations.getDefaultStations()) {
            subwayMap.addVertex(station.getName());
        }
    }

    private void addDefaultEdges() {
        for (Section section : DefaultSections.getSections());
    }
}
