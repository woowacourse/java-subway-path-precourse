package subway.repository;

import subway.domain.SubwayMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubwayMapRepository {
    private static final List<SubwayMap> SUBWAY_MAPS = new ArrayList<>();

    public static List<SubwayMap> maps() {
        return Collections.unmodifiableList(SUBWAY_MAPS);
    }

    public static void addMap(SubwayMap subwayMap) {
        SUBWAY_MAPS.add(subwayMap);
    }
}
