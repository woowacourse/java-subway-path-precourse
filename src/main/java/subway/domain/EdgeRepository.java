package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EdgeRepository {
    public static final String ERR_EDGE_NOT_IN_REPO = "존재하지 않는 엣지 값입니다.";
    private static final List<Edge> edges = new ArrayList<>();
    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }
    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static int getElapsedTime (List<Station> stations) {
        int elapsedTime = 0;
        for (int i = 0; i < stations.size()-1; i ++) {
            elapsedTime += getEdge(stations.get(i), stations.get(i+1)).getTime();
        }
        return elapsedTime;
    }

    public static int getRouteLength (List<Station> stations) {
        int length = 0;
        for (int i =0; i < stations.size()-1; i ++) {
            length += getEdge(stations.get(i), stations.get(i+1)).getDistance();
        }
        return length;
    }

    private static Edge getEdge (Station from, Station to) {
        return edges().stream()
                      .filter(edge -> edge.getFrom().equals(from))
                      .filter(edge -> edge.getTo().equals(to))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException(ERR_EDGE_NOT_IN_REPO));
    }
}
