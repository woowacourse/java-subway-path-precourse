package subway.util;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathCalculator {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    

}
