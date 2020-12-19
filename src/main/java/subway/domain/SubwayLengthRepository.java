package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwayLengthRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> subwayPath = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<Station, DefaultWeightedEdge> subwayLength() {
        return subwayPath;
    }

    public static void addStation(Station station) {
        subwayPath.addVertex(station);
    }

    public static void setPathWeightWithTwoStation(Station source, Station target, int weight) {
        subwayPath.setEdgeWeight(subwayPath.addEdge(source, target), weight);
    }

    public static int getEdgeWeightWithTwoStations(Station source, Station target) {
        return (int) subwayPath.getEdgeWeight(subwayPath.getEdge(source, target));
    }
}
