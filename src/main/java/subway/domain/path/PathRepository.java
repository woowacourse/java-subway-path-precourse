package subway.domain.path;

import java.util.HashMap;
import java.util.Map;
import subway.domain.weight.WeightType;

public class PathRepository {
    private static Map<WeightType, ShortestPath> path = new HashMap<>();

    static {
        path.put(WeightType.DISTANCE, new ShortestPath(WeightType.DISTANCE));
        path.put(WeightType.TIME, new ShortestPath(WeightType.TIME));
    }
}
