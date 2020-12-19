package subway.domain.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stations {

    private final List<Station> stations;

    private Stations(List<Station> stations) {
        this.stations = stations;
    }

    public static Stations of(Station upwardLastStation, Station nextStation) {
        if (upwardLastStation.equals(nextStation)) {
            throw new SectionDuplicationException();
        }
        List<Station> stations = Stream.of(upwardLastStation, nextStation)
                .collect(Collectors.toList());
        return new Stations(stations);
    }
}
