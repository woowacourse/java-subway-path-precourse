package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeSectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);
}
