package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @Test
    public void findBy테스트() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("교대역");

        // when
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);

        // then
        assertEquals(station1, StationRepository.findByName(station1.getName()));
    }

}