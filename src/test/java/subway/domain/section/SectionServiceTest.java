package subway.domain.section;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.station.StationService;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.SectionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {
    SectionService sectionService;
    StationService stationService;

    @BeforeEach
    void before() {
        sectionService = new SectionService(new SectionRepository());
        stationService = new StationService();
        String stationName = "행복역";
        String stationName2 = "사랑역";
        String stationName3 = "희망역";
        String stationName4 = "소망역";
        stationService.saveStation(new StationSaveReqDto(stationName));
        stationService.saveStation(new StationSaveReqDto(stationName2));
        stationService.saveStation(new StationSaveReqDto(stationName3));
        stationService.saveStation(new StationSaveReqDto(stationName4));

        String lineName = "1호선";
        String upwardName = "행복역";
        String downwardName = "사랑역";
        sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName));
        sectionService.addStation(new SectionStationAddReqDto(lineName, stationName3, 2));
    }

    @AfterEach
    void after() {
        stationService.removeAll();
        sectionService.removeAll();
    }

    @Test
    @DisplayName("노선을 저장한다")
    void testSaved() {
        //given
        String lineName = "2호선";
        String upwardName = "희망역";
        String downwardName = "소망역";

        //when
        Section savedSection = sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName));

        //then
        assertThat(savedSection.getLineName()).isEqualTo(lineName);
    }

    @Test
    @DisplayName("이미 저장된 노선일 시 에러가 발생한다.")
    void testAlreadySavedError() {
        //given
        String lineName = "1호선";
        String upwardName = "희망역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.LINE_ALREADY_EXIST.getMessage());
    }

    @Test
    @DisplayName("등룍하려는 상행 종점역이 존재하지 않으면 에러가 발생한다")
    void testUpwardNotFound() {
        //given
        String lineName = "2호선";
        String upwardName = "역곡역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class);
    }

    @Test
    @DisplayName("등룍하려는 하행 종점역이 존재하지 않으면 에러가 발생한다")
    void testDownwardNotFound() {
        //given
        String lineName = "2호선";
        String upwardName = "소망역";
        String downwardName = "역곡역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class);
    }

    @Test
    @DisplayName("등룍하려는 하행 종점역이 앞서 등록한 상행 종점역일 시 에러가 발생한다")
    void testDownwardSaveError() {
        //given
        String lineName = "2호선";
        String upwardName = "소망역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_SAME_STATION_NAME.getMessage());
    }
}

