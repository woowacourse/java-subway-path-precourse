package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathRepository {
    private static Map<String, Path> pathMap = new HashMap<>();

    public static void init() {
        for (Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();
            for(int i = 1; i < stations.size(); i++) {
                Station start = stations.get(i - 1);
                Station end = stations.get(i);
                pathMap.put(
                        String.format("%s/%s", start.getName(), end.getName()),
                        new Path(end.getDistance(), end.getTime())
                );
            }
        }
    }

    public Path getPath(String startStationName, String endStationName) {
        return pathMap.get(String.format("%s/%s", startStationName, endStationName));
    }
}