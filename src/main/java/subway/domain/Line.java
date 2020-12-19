package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Path> paths;

    public Line(String name, Path path) {
        this.paths = new ArrayList<>();
        addPath(path);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public void addEdge(WeightedMultigraph<Station, DefaultWeightedEdge> graph, Weight weight) {
        paths.forEach(path -> {
            addVertex(path.getStartStation(), graph);
            addVertex(path.getEndStation(), graph);
            graph.setEdgeWeight(graph.addEdge(path.getStartStation(), path.getEndStation()), Weight.getWeight(path, weight));
        });
    }

    private void addVertex(Station station, WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        if (!graph.containsVertex(station)) {
            graph.addVertex(station);
        }
    }
}
