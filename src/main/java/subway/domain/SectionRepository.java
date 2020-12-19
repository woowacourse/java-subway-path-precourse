package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceWeightedGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeightedGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<String, DefaultWeightedEdge> distanceWeightedGraph() {
        return distanceWeightedGraph;
    }

    public static void addSection(Section section) {
        String departureStationName = section.getDepartureStation().getName();
        String arrivalStationName = section.getArrivalStation().getName();

        distanceWeightedGraph.addVertex(departureStationName);
        distanceWeightedGraph.addVertex(arrivalStationName);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge(departureStationName, arrivalStationName), section.getDistance());

        timeWeightedGraph.addVertex(departureStationName);
        timeWeightedGraph.addVertex(arrivalStationName);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge(departureStationName, arrivalStationName), section.getTime());
    }
}
