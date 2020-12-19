package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StationRepositoryTest {

    private StationRepository stationRepository;

    @BeforeEach
    public void initStationRepository() {
        stationRepository = new StationRepository();
    }

    @Test
    @DisplayName("역 추가 테스트")
    public void addStation_NewStation_StationIsAdded() {

        // given
        Station station = new Station("봉천역");

        // when
        stationRepository = stationRepository.addStation(station);

        //then
        assertThat(stationRepository.stations()).containsExactly(station);
    }

    @Test
    @DisplayName("여러 역 추가 테스트")
    public void addStations_NewStations_StationsAreAdded() {

        // given
        String[] stationNames = {"봉천역", "신림역", "신대방역"};

        // when
        stationRepository = stationRepository.addStations(stationNames);

        //then
        assertThat(stationRepository.stations()).extracting(Station::getName)
                .containsExactly("봉천역", "신림역", "신대방역");
    }

    @Test
    @DisplayName("역 삭제 테스트")
    public void deleteStation_OldStation_StationRemoved() {

        // given
        Station station = new Station("봉천역");
        stationRepository = stationRepository.addStation(station);

        // when
        stationRepository = stationRepository.deleteStation("봉천역");

        //then
        assertThat(stationRepository.stations()).isEmpty();
    }

    @Test
    @DisplayName("모든 역 삭제 테스트")
    public void deleteAll_StationRepository_EmptyStationRepository() {

        // given
        Station station = new Station("봉천역");
        stationRepository = stationRepository.addStation(station);

        // when
        stationRepository = stationRepository.deleteAll();

        //then
        assertThat(stationRepository.stations()).isEmpty();
    }
}
