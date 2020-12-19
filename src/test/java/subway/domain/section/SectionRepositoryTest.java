package subway.domain.section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SectionRepositoryTest {

    @DisplayName("구간을 추가하는 기능을 테스트한다")
    @Test
    void testAddSection() {
        //given
        Station startStation = new Station("교대역");
        Station arrivalStation = new Station("강남역");
        int runTime = 3;
        int distance = 2;

        Section section = new Section(startStation, arrivalStation, runTime, distance);

        //when
        SectionRepository.addSection(section);

        //then
        List<Section> sections = SectionRepository.sections();
        assertThat(sections.get(0)).isEqualTo(section);
    }
}
