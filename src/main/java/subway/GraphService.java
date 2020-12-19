package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class GraphService {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_DISTANCE = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_TIME = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void init() {
        for (String stationName : DataInitService.stationNames) {
            GRAPH_DISTANCE.addVertex(stationName);
            GRAPH_TIME.addVertex(stationName);
        }
        //initDistanceGraph();
        //initTimeGraph();
    }
}
