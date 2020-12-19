package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.station.Station;
import subway.exception.AlreadyAddedStationException;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    static {    //샘플 데이터
        new SectionRepository();
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {

        if (stations.contains(station)) {
            throw new AlreadyAddedStationException(station);
        }

        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public Station findByName(String name) {
        return stations.stream()
            .filter(station -> station.isMatchName(name))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("[ERROR] 해당 이름의 역을 찾을 수 없습니다.");
            });
    }

    public void deleteAll() {
        stations.clear();
    }
}
