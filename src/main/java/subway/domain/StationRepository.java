package subway.domain;

import java.util.*;

public class StationRepository {
    static final Station stationKyoDae = new Station("교대역");
    static final Station stationGangNam = new Station("강남역");
    static final Station stationYeokSam = new Station("역삼역");
    static final Station stationNamBu = new Station("남부터미널역");
    static final Station stationYangJae = new Station("양재역");
    static final Station stationYangJaeForest = new Station("양재시민의숲역");
    static final Station stationMaeBong = new Station("매봉역");

    private static final List<Station> stations = Arrays.asList(stationKyoDae, stationGangNam,
                                                    stationYeokSam, stationNamBu, stationYangJae,
                                                    stationYangJaeForest, stationMaeBong);
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
}
