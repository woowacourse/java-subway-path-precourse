package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();
    
    public static void addEdge(Edge edge) {
        edges.add(edge);
        TimeGraph.setEdge(edge.getLeftEndStation(), edge.getRightEndStation(), edge.getTime());
        DistanceGraph.setEdge(edge.getLeftEndStation(), edge.getRightEndStation(), edge.getDistance());
    }
}
