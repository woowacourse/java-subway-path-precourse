package subway.domain;

import subway.view.PathMessages;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        InitialSubway.initializeLines();
        InitialSubway.initializeSections();
        InitialSubway.initializeDistances();
        InitialSubway.initializeTimes();
    }

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

    public static Line getLine(String lineName) throws IllegalArgumentException {
        return LineRepository
                .lines()
                .stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean isStationInUse(String stationName) {
        return lines.stream()
                .map(Line::getSections)
                .map(Sections::sections)
                .flatMap(Collection::stream)
                .map(Station::getName)
                .anyMatch(stationName::equals);
    }

    public static void validateStationInUse(String stationName) throws IllegalArgumentException {
        if (!isStationInUse(stationName)) {
            throw new IllegalArgumentException(PathMessages.STATION_NOT_IN_USE_ERROR.getMessage());
        }
    }
}
