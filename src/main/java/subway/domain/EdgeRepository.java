package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EdgeRepository {
    private static List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() { return Collections.unmodifiableList(edges); }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }
}
