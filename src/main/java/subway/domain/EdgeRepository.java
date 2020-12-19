package subway.domain;

import java.util.*;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static Edge getEdgeByFromAndTo(String from, String to) {
        return edges.stream().filter(edge -> (Objects.equals(edge.getFrom(), from) && Objects.equals(edge.getTo(), to))).findFirst().get();
    }

    public static boolean deleteEdgeByFromAndTo(String from, String to) {
        return edges.removeIf(edge -> (Objects.equals(edge.getFrom(), from) && Objects.equals(edge.getTo(), to)));
    }

    public static void deleteAll() {
        edges.clear();
    }
}
