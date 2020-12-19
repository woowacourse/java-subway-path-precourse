package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();
    public static List<Edge> lines() {
        return Collections.unmodifiableList(edges);
    }
    public static void addLine(Edge edge) {
        edges.add(edge);
    }
}
