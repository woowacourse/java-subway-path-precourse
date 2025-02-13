package subway.domain.section;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class SectionRepositoryTest {
    @Test
    public void exists() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        Section section = new Section(line, source, sink, 0, 0);
        assertThat(SectionRepository.exists(section)).isEqualTo(false);
        SectionRepository.addSection(section);
        assertThat(SectionRepository.exists(section)).isEqualTo(true);
    }

    @AfterEach
    public void init() {
        SectionRepository.deleteAll();
    }
}
