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


class SectionServiceTest {

    @BeforeAll
    static void beforeAll() {
        SectionRepository.addSection(new Section("교대역", "강남역", 2, 3));
        SectionRepository.addSection(new Section("강남역", "역삼역", 2, 3));
        SectionRepository.addSection(new Section("강남역", "역삼역", 5, 3));
    }

    @AfterAll
    static void afterAll() {
        SectionRepository.deleteAll();
    }

    @DisplayName("최단거리를 찾는 기능을 테스트한다")
    @Test
    void testFindShortestPath() {
        //given
        Station startStation = new Station("강남역");
        Station arrivalStation = new Station("역삼역");

        //when
        List<Station> shortestPath = SectionService.findDistanceShortestPath(startStation, arrivalStation);

        //then
        assertThat(shortestPath).hasSize(2);
    }
}
