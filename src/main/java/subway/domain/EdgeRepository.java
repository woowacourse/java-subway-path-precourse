package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static boolean deleteEdgeByFromAndTo(String from, String to) {
        return edges.removeIf(edge -> (Objects.equals(edge.getFrom(), from) && Objects.equals(edge.getTo(), to)));
    }

    public static void deleteAll() {
        edges.clear();
    }
}
