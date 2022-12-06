package subway.domain.graph;

import subway.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class TimeGraphRepository {
    private static final List<TimeGraph> timeGraphs = new ArrayList<>();

    private TimeGraphRepository() {}

    public static void setUp(List<TimeGraph> inputTimeGraph) {
        timeGraphs.addAll(inputTimeGraph);
    }

    public static void addGraph(TimeGraph timeGraph) {
        timeGraphs.add(timeGraph);
    }

    public static TimeGraph findByLine(Line line) {
        return timeGraphs.stream()
                .filter(graph -> graph.lineEquals(line))
                .findAny()
                .orElse(null);
    }

}
