package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GraphRepository {

    private final static Map<String, Graph> graphMap = new HashMap<>();

    public static Map<String, Graph> graphMaps() {
        return Collections.unmodifiableMap(graphMap);
    }

    public static void addGraph(String graphName) {
        graphMap.putIfAbsent(graphName, new Graph());
    }

    public static Graph findGraphByName(String graphName) {
        return graphMap.getOrDefault(graphName, null);
    }

    private static boolean checkDuplication(String graphName) {
        return graphMaps().containsKey(graphName);
    }

}
