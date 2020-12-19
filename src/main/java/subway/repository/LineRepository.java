package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Boolean isConnected(Station startStation, Station endStation) {
        List<Line> lines = stationContainLines(startStation);
        for (Line line : lines) {
            if (line.isStationContained(endStation)) {
                return true;
            }
        }
        return false;
    }

    private static List<Line> stationContainLines(Station station) {
        return lines().stream()
            .filter(line -> line.isStationContained(station))
            .collect(Collectors.toList());
    }
}
