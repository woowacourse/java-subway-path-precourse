package subway.domain.section.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.section.model.Section;
import subway.domain.section.model.SectionRepository;
import subway.station.model.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class SectionServiceTest {

    @BeforeAll
    static void beforeAll() {
        SectionRepository.addSection(new Section("교대역", "강남역", 2, 3));
        SectionRepository.addSection(new Section("강남역", "역삼역", 2, 3));
        SectionRepository.addSection(new Section("교대역", "역삼역", 5, 3));
    }

    @AfterAll
    static void afterAll() {
        SectionRepository.deleteAll();
    }

    @DisplayName("최단거리를 경로를 찾는 기능을 테스트한다")
    @Test
    void testFindDistanceShortestPath() {
        //given
        Station startStation = new Station("교대역");
        Station arrivalStation = new Station("역삼역");

        //when
        List<Station> shortestPath = SectionService.findDistanceShortestPath(startStation, arrivalStation);

        //then
        assertThat(shortestPath).hasSize(2);
    }

    @DisplayName("최소시간 경로를 찾는 기능을 테스트한다")
    @Test
    void testFindRunTimeShortestPath() {
        //given
        Station startStation = new Station("교대역");
        Station arrivalStation = new Station("역삼역");

        //when
        List<Station> shortestPath = SectionService.findRunTimeShortestPath(startStation, arrivalStation);

        //then
        assertThat(shortestPath).hasSize(3);
        assertThat(shortestPath)
                .usingElementComparatorOnFields("name")
                .containsExactlyInAnyOrder(startStation, new Station("강남역"), arrivalStation);
    }

    @DisplayName("출발역과 도착역이 동일하면 최소시간 경로를 찾는 기능은 예외를 발생시킨다")
    @Test
    void testFindDistanceShortestPathIfStartStationEqualToArrivalStation() {
        //given
        Station startStation = new Station("교대역");
        Station arrivalStation = new Station("교대역");

        //when //then
        assertThatThrownBy(() -> SectionService.findDistanceShortestPath(startStation, arrivalStation))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("출발역과 도착역이 동일하면 최소시간 경로를 찾는 기능은 예외를 발생시킨다")
    @Test
    void testFindRunTimeShortestPathIfStartStationEqualToArrivalStation() {
        //given
        Station startStation = new Station("교대역");
        Station arrivalStation = new Station("교대역");

        //when //then
        assertThatThrownBy(() -> SectionService.findRunTimeShortestPath(startStation, arrivalStation))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
