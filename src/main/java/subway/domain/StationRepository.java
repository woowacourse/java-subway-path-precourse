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

    //테스트용
    public static void printAllStations() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n## 역 목록");
        for (Station station : stations) {
            sb.append("\n[INFO] ");
            sb.append(station.getName());
        }
        System.out.println(sb);
    }

}
