package subway.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.InitializeSubwayPath;
import subway.domain.Station;
import subway.exception.StationNotExistException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StationServiceTest {
    @BeforeEach
    public void setUp() {
        InitializeSubwayPath.initialize();
    }

    @Test
    public void getStationByNameWithValidNameTest(){
        //given
        String stationName = "강남역";
        //when
        Station station = StationService.getStationByName(stationName);
        //then
        Assertions.assertThat(station.getName()).isEqualTo(stationName);
    }

    @Test
    public void getStationByNameWithInvalidNameTest(){
        //given
        String stationName = "서울역";
        //when
        //then
        assertThrows(StationNotExistException.class, ()->{
            StationService.getStationByName(stationName);
        });
    }
}