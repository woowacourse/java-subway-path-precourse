package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import subway.domain.line.Line;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class ShortCostResponseTest {
    @Test
    public void constructor() {
        Line line = new Line("line");
        Station source = new Station("source");
        Station sink = new Station("sink");
        List<Station> stationList = Arrays.asList(source, sink);
        int distance = 1;
        int time = 8;
        Section section = new Section(line, source, sink, distance, time);
        source.addSection(section);
        ShortCostResponse shortCostResponse = new ShortCostResponse(stationList);
        assertThat(shortCostResponse.getTotalDistance()).isEqualTo(distance);
        assertThat(shortCostResponse.getTotalTime()).isEqualTo(time);
        assertThat(shortCostResponse.getStationNameList()).containsExactly(source.getName(), sink.getName());
    }
}
