package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static void setCost(String prevStationName, String nextStationName, int timeCost, int distanceCost) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(prevStationName)) {
                stations().get(i).addNodeData(nextStationName, timeCost, distanceCost);
            }
            if (stations.get(i).getName().equals(nextStationName)) {
                stations.get(i).addNodeData(prevStationName, timeCost, distanceCost);
            }
        }
    }
}
