package subway.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.Constants;

class StationRepositoryTest {

    private static final List<String> stationNames = new ArrayList<>();
    private static final List<Station> stations = new ArrayList<>();

    private static final String NON_EXIST_STATION_NAME = "존재하지않는역";

    @BeforeAll
    static void setUpBeforeAll() {
        for (String[] stationNameArray : Constants.INITIAL_STATION_NAMES_IN_LINES) {
            stationNames.addAll(Arrays.stream(stationNameArray)
                .filter(stationName -> !stationNames.contains(stationName))
                .collect(toList()));
        }
        stationNames.forEach(stationName -> stations.add(new Station(stationName)));
    }

    @BeforeEach
    void setUp() {
        StationRepository.deleteAll();
        stations.forEach(StationRepository::addStation);
    }

    @Test
    void addStation_NameDuplicated_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            StationRepository.addStation(stations.get(0))
        );
    }

    @Test
    void addStation_ValidItem_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() ->
            StationRepository.addStation(new Station(NON_EXIST_STATION_NAME))
        );
    }

    @Test
    void deleteStation_InvalidItem_False() {
        assertThat(StationRepository.deleteStation(NON_EXIST_STATION_NAME)).isFalse();
    }

    @Test
    void deleteStation_ValidItem_True() {
        assertThat(StationRepository.deleteStation(stations.get(0).getName())).isTrue();
    }
}
