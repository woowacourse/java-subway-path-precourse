package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;

public class StationTest {
    @Test
    public void addSection() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(source.getSectionList()).hasSize(0);
        source.addSection(section);
        assertThat(source.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__SectionAddingOtherSourceStationReceiveException() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station other = new Station("other");
        Station sink = new Station("sink");
        Section section = new Section(line, other, sink, 0, 0);
        String message = "구간 추가시 다른 시작역을 받았습니다.";
        assertThatThrownBy(() -> source.addSection(section)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findDistanceTo() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        int distance = 1;
        Section section = new Section(line, source, sink, distance, 0);
        source.addSection(section);
        assertThat(source.findDistanceTo(sink)).isEqualTo(distance);
    }

    @Test
    public void findDistanceTo__NotExistsPathToSinkStationException() {
        Station source = new Station("source");
        Station sink = new Station("sink");
        String message = "종료역까지 경로가 존재하지 않습니다.";
        assertThatThrownBy(() -> source.findDistanceTo(sink)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findTimeTo() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        int time = 8;
        Section section = new Section(line, source, sink, 0, time);
        source.addSection(section);
        assertThat(source.findTimeTo(sink)).isEqualTo(time);
    }

    @Test
    public void findTimeTo__NotExistsPathToSinkStationException() {
        Station source = new Station("source");
        Station sink = new Station("sink");
        String message = "종료역까지 경로가 존재하지 않습니다.";
        assertThatThrownBy(() -> source.findTimeTo(sink)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
