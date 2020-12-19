package subway.domain.subwaymap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SubwayMapRepository {

    private static final Map<String, SubwayMap> subwayMaps = new HashMap<>();

    public static Map<String, SubwayMap> subwayMaps() {
        return Collections.unmodifiableMap(subwayMaps);
    }

    public static void addSubwayMaps(String subwayMapName, SubwayMap subwayMap) {
        subwayMaps.put(subwayMapName, subwayMap);
    }

    public static void deleteAll() {
        subwayMaps.clear();
    }

}
