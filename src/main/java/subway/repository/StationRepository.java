package subway.repository;

import static subway.exception.ErrorInputException.ErrorMessage.IS_NOT_REGISTERED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Station;
import subway.exception.ErrorInputException;

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

    public static Station getStation(String name) {
        while (true) {
            try {
                return stations.stream()
                        .filter(station -> station.getName().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new ErrorInputException(IS_NOT_REGISTERED));
            } catch (ErrorInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
