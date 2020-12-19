package subway.domain.station;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationServiceTest {

    StationService stationService;

    @BeforeEach
    void before() {
        stationService = new StationService();
        String stationName = "행복역";
        String stationName2 = "사랑역";
        String stationName3 = "희망역";
        String stationName4 = "소망역";
        stationService.saveStation(new StationSaveReqDto(stationName));
        stationService.saveStation(new StationSaveReqDto(stationName2));
        stationService.saveStation(new StationSaveReqDto(stationName3));
        stationService.saveStation(new StationSaveReqDto(stationName4));
    }

    @AfterEach
    void after() {
        stationService.removeAll();
    }

    @Test
    @DisplayName("이미 등록된 지하철 역일 시 에러가 발생한다. ")
    void testDuplicateSave() {
        //given
        String name = "인천시청역";
        String name2 = "인천시청역";

        //when
        Station savedIncheonStation = stationService.saveStation(new StationSaveReqDto(name));

        //then
        assertThatThrownBy(() -> stationService.saveStation(new StationSaveReqDto(name2)))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_ALREADY_EXIST.getMessage());
    }
}