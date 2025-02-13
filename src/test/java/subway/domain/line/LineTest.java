package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.section.Section;
import subway.domain.station.Station;

public class LineTest {
    @Test
    public void addSection() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(line.getSectionList()).hasSize(0);
        line.addSection(section);
        assertThat(line.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__SectionAddingOtherLineReceiveException() {
        Line line = new Line("line");
        Line other = new Line("other");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(other, source, sink, 0, 0);
        String message = "구간 추가시 다른 노선을 받았습니다.";
        assertThatThrownBy(() -> line.addSection(section)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
