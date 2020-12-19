package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static subway.utils.Constant.FOR_LOOF_INDEX_ONE;

public class PathRepository {
    private static Map<String, Path> pathMap = new HashMap<>();

    public static void init() {
        for (Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();
            for (int i = FOR_LOOF_INDEX_ONE; i < stations.size(); i++) {
                Station start = stations.get(i - FOR_LOOF_INDEX_ONE);
                Station end = stations.get(i);
                pathMap.put(
                        String.format("%s/%s", start.getName(), end.getName()),
                        new Path(end.getDistance(), end.getTime())
                );
            }
        }
    }

    public static Path getPath(String startStationName, String endStationName) {
        return pathMap.get(String.format("%s/%s", startStationName, endStationName));
    }
}