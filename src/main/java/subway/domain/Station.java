package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
    private String name;
    private List<Edge> edges;

    public Station(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    // 추가 기능 구현
}
