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

class SectionRepositoryTest {

    private static final String[] LINE_NAMES = {"2호선", "3호선", "신분당선"};
    private static final String[][] STATION_NAMES_IN_LINES = {
        {"교대역", "강남역", "역삼역"},
        {"교대역", "남부터미널역", "양재역", "매봉역"},
        {"강남역", "양재역", "양재시민의숲역"}
    };
    private static final int[][][] GAPS_IN_LINES = {
        {{2, 3}, {2, 3}},
        {{3, 2}, {6, 5}, {1, 1}},
        {{2, 8}, {10, 3}}
    };

    private static final List<Section> sections = new ArrayList<>();

    @BeforeAll
    static void setUpBeforeAll() {
        for (int i = 0; i < LINE_NAMES.length; i++) {
            final Line line = new Line(LINE_NAMES[i]);
            final List<Station> stations = new LinkedList<>();
            final List<Gap> gaps = new LinkedList<>();
            for (String stationName : STATION_NAMES_IN_LINES[i]) {
                stations.add(new Station(stationName));
            }
            for (int[] gap : GAPS_IN_LINES[i]) {
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
        assertThat(SectionRepository.deleteSectionByLineName(LINE_NAMES[sections.size() - 1]))
            .isFalse();
    }

    @Test
    void deleteSectionByLineName_ValidName_True() {
        assertThat(SectionRepository.deleteSectionByLineName(LINE_NAMES[0])).isTrue();
    }
}
