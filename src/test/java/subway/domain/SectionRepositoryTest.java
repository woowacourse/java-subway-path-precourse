package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.Constants;

class SectionRepositoryTest {

    private static final List<Section> sections = new ArrayList<>();

    @BeforeAll
    static void setUpBeforeAll() {
        for (int i = 0; i < Constants.INITIAL_LINE_NAMES.length; i++) {
            final Line line = new Line(Constants.INITIAL_LINE_NAMES[i]);
            final List<Station> stations = new LinkedList<>();
            final List<Gap> gaps = new LinkedList<>();
            for (String stationName : Constants.INITIAL_STATION_NAMES_IN_LINES[i]) {
                stations.add(new Station(stationName));
            }
            for (int[] gap : Constants.INITIAL_GAPS_BETWEEN_STATIONS_OF_SECTIONS[i]) {
                gaps.add(new Gap(gap[0], gap[1]));
            }
            sections.add(new Section(line, stations, gaps));
        }
    }

    @BeforeEach
    void setUp() {
        SectionRepository.deleteAll();
        for (int i = 0; i < sections.size() - 1; i++) {
            SectionRepository.addSection(sections.get(i));
        }

    }

    @Test
    void addSection_NameDuplicate_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            SectionRepository.addSection(sections.get(0))
        );
    }

    @Test
    void addSection_ValidItem_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() ->
            SectionRepository.addSection(sections.get(sections.size() - 1))
        );
    }

    @Test
    void deleteSectionByLineName_LineNotExist_False() {
        assertThat(
            SectionRepository
                .deleteSectionByLineName(Constants.INITIAL_LINE_NAMES[sections.size() - 1])
        ).isFalse();
    }

    @Test
    void deleteSectionByLineName_ValidName_True() {
        assertThat(
            SectionRepository.deleteSectionByLineName(Constants.INITIAL_LINE_NAMES[0])
        ).isTrue();
    }
}
