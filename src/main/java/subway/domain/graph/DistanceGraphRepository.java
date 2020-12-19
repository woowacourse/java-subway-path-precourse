package subway.domain.graph;

import java.util.ArrayList;
import java.util.List;

public class DistanceGraphRepository {
    public static final List<DistanceGraph> graphs = new ArrayList<>();

    public static void add(DistanceGraph graph) {
        graphs.add(graph);
    }
}
