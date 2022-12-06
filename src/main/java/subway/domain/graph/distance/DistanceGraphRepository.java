package subway.domain.graph.distance;

import subway.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class DistanceGraphRepository {
    private static final List<DistanceGraph> distanceGraphs = new ArrayList<>();

    private DistanceGraphRepository() {}

    public static void setUp(List<DistanceGraph> inputDistanceGraphs) {
        distanceGraphs.addAll(inputDistanceGraphs);
    }

    public static void addGraph(DistanceGraph distanceGraph) {
        distanceGraphs.add(distanceGraph);
    }

    public static DistanceGraph findByLine(Line line) {
        return distanceGraphs.stream()
                .filter(graph -> graph.lineEquals(line))
                .findAny()
                .orElse(null);
    }

}
