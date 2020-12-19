package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.InitialData;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static Map<Station, Map<Station, Integer>> convertPathsToDistanceMap() {
        Map<Station, Map<Station, Integer>> distanceMap = new HashMap<>();
        List<Station> departureStations = paths.stream()
            .map(Path::getDepartureStation)
            .collect(Collectors.toList());

        for (Station departureStation : departureStations) {
            distanceMap.put(departureStation, getStationDistanceMap(departureStation));
        }
        return distanceMap;
    }

    public static Map<Station, Map<Station, Integer>> convertPathsToTimeMap() {
        Map<Station, Map<Station, Integer>> distanceMap = new HashMap<>();
        List<Station> departureStations = paths.stream()
            .map(Path::getDepartureStation)
            .collect(Collectors.toList());

        for (Station departureStation : departureStations) {
            distanceMap.put(departureStation, getStationTimeMap(departureStation));
        }
        return distanceMap;
    }

    private static Map<Station, Integer> getStationTimeMap(Station departureStation) {
        Map<Station, Integer> map = new HashMap<Station, Integer>();
        for (Path path : paths) {
            isSameStationByTime(departureStation, map, path);
        }
        return map;
    }

    private static Map<Station, Integer> getStationDistanceMap(Station departureStation) {
        Map<Station, Integer> map = new HashMap<Station, Integer>();
        for (Path path : paths) {
            isSameStationByDistance(departureStation, map, path);
        }
        return map;
    }

    private static void isSameStationByTime(Station departureStation, Map<Station, Integer> map,
        Path path) {
        if (path.getDepartureStation().equals(departureStation)) {
            map.put(path.getArrivalStation(), path.getTime());
        }
    }

    private static void isSameStationByDistance(Station departureStation, Map<Station, Integer> map,
        Path path) {
        if (path.getDepartureStation().equals(departureStation)) {
            map.put(path.getArrivalStation(), path.getDistance());
        }
    }

}
