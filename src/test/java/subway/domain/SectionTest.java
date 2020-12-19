package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SectionTest {

    private static final String LINE_NAME = "2호선";
    private static final String[] STATION_NAMES = {"교대역", "강남역", "역삼역"};
    private static final int[][] GAPS = {{2, 3}, {2, 3}};
    private static final Line line = new Line(LINE_NAME);
    private static final List<Station> stations = new LinkedList<>();
    private static final List<Gap> gaps = new LinkedList<>();
    private static Section section;

    @BeforeAll
    static void setUp() {
        for (String stationName : STATION_NAMES) {
            stations.add(new Station(stationName));
        }
        for (int[] gap : GAPS) {
            gaps.add(new Gap(gap[0], gap[1]));
        }
        section = new Section(line, stations, gaps);
    }

    @Test
    void getStationByIndex_ValidIndex_Pass() {
        for (int i = 0; i < stations.size(); i++) {
            assertThat(section.getStationByIndex(i)).isEqualTo(stations.get(i));
        }
    }

    @Test
    void getStationByIndex_InvalidIndex_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            section.getStationByIndex(-1)
        );
        assertThatIllegalArgumentException().isThrownBy(() ->
            section.getStationByIndex(stations.size())
        );
    }

    @Test
    void getGapByTwoIndexes_ValidIndexes_Pass() {
        assertThat(section.getGapByTwoIndexes(0, 1)).isEqualTo(gaps.get(0));
    }

    @Test
    void getGapByTwoIndexes_InvalidIndexesDifference_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            section.getGapByTwoIndexes(0, 2)
        );
    }

    @Test
    void getGapByTwoIndexes_InvalidIndexesRange_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            section.getGapByTwoIndexes(-1, 0)
        );
        assertThatIllegalArgumentException().isThrownBy(() ->
            section.getGapByTwoIndexes(stations.size(), stations.size() - 1)
        );
    }

    @Test
    void getLine_SameLine_Pass() {
        assertThat(section.getLine()).isEqualTo(line);
    }
}