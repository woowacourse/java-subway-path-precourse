package subway.domain.section.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.station.model.Station;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SectionTest {

    @DisplayName("구간 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitSection() {
        //given
        String startStationName = "교대역";
        String arrivalStationName = "강남역";
        Station startStation = new Station(startStationName);
        Station arrivalStation = new Station(arrivalStationName);
        int runTime = 3;
        int distance = 2;

        //when
        Section section = new Section(startStation, arrivalStation, runTime, distance);

        //then
        assertAll(
                () -> assertThat(section).extracting("startStation").isEqualTo(startStation),
                () -> assertThat(section).extracting("arrivalStation").isEqualTo(arrivalStation),
                () -> assertThat(section).extracting("runTime").extracting("runTime").isEqualTo(runTime),
                () -> assertThat(section).extracting("distance").extracting("distance").isEqualTo(distance)
        );
    }
}
