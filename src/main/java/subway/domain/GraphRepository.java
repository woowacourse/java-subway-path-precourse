package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GraphRepository {

    private final static Map<GraphType, Graph> graphMap = new HashMap<>();

    public static Map<GraphType, Graph> graphMaps() {
        return Collections.unmodifiableMap(graphMap);
    }

    public static void addGraph(GraphType graphType) {
        graphMap.putIfAbsent(graphType, new Graph());
    }

    public static Graph findGraphByType(GraphType graphType) {
        return graphMap.getOrDefault(graphType, null);
    }

}
