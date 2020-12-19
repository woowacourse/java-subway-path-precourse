package subway.domain.entity;

import subway.domain.path.SubwayMapGraph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stations {
    private static final SubwayMapGraph SUBWAY_MAP_GRAPH = SubwayMapGraph.getInstance();

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
}
