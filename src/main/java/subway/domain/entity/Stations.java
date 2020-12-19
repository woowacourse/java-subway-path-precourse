package subway.domain.entity;

import subway.domain.path.SubwayGraph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stations {
    private static final SubwayGraph SUBWAY_MAP_GRAPH = SubwayGraph.getInstance();
    private static final int INDEX_ADJUSTMENT = 1;

    private final List<Station> stations;

    private Stations(List<Station> stations) {
        this.stations = stations;
    }

    public static Stations of(Station upwardLastStation, Station nextStation, Section section) {
        if (upwardLastStation.equals(nextStation)) {
            throw new SectionDuplicationException();
        }
        SUBWAY_MAP_GRAPH.addStationToGraph(upwardLastStation, nextStation, section);
        List<Station> stations = Stream.of(upwardLastStation, nextStation)
                .collect(Collectors.toList());
        return new Stations(stations);
    }

    public void addStation(Station station, Section section) {
        int stationCounts = stations.size();
        Station lastStation = stations.get(stationCounts - INDEX_ADJUSTMENT);
        SUBWAY_MAP_GRAPH.addStationToGraph(lastStation, station, section);
        stations.add(station);
    }
}
