package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.domain.Line;
import subway.domain.line.domain.LineRepository;
import subway.domain.line.dto.SectionInsertRequestDto;
import subway.domain.line.service.LineStationService;
import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;

public class LineStationServiceTest {

    final String LINE_NAME = "test line";
    final double DISTANCE = 1;
    final double TIME = 1;
    final Station upstreamStation = Station.from("test station1");
    final Station downstreamStation = Station.from("test station2");
    final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation, DISTANCE, TIME);
    final int STATIONS_SIZE = 2;

    @BeforeEach
    void before() {
        LineRepository.save(line);
    }

    @AfterEach
    void after() {
        LineRepository.deleteAll();
    }

    @DisplayName("지하철 노선에 구간을 추가한다.")
    @Test
    void addSection() {
        final double distance = 1;
        final double time = 1;
        final String insertedStationName = "inserted station";
        final Station station = Station.from("inserted station");
        StationRepository.save(station);
        LineStationService.addSection(new SectionInsertRequestDto(LINE_NAME, insertedStationName, distance, time));

        assertEquals(line.getLineStations().size(), STATIONS_SIZE + 1);
        assertSame(line.getLastDownstreamStation(), station);
    }
}
