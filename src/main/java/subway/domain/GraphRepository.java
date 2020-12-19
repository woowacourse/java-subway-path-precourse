package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GraphRepository {

    private final static Map<String, Graph> graphMap = new HashMap<>();

    public Map<String, Graph> graphMaps() {
        return Collections.unmodifiableMap(graphMap);
    }

    public void addGraph(String graphName) {

        if (checkDuplication(graphName)) {
            //error
            return;
        }

        graphMap.put(graphName, new Graph());
    }

    public Graph getGraph(String graphName) {

        if (graphMaps().containsKey(graphName)) {
            return graphMap.get(graphName);
        }
        return null;
    }

    private boolean checkDuplication(String graphName) {
        return graphMaps().containsKey(graphName);
    }

}
