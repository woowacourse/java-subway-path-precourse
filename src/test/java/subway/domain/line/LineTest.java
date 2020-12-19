package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.domain.Line;
import subway.domain.line.exception.ShorterThanMinLineNameException;
import subway.domain.station.domain.Station;

@DisplayName("지하철 노선 기능에 대한 테스트")
class LineTest {

    final String LINE_NAME = "test line1";
    final Station upstreamStation = Station.from("test1");
    final Station downstreamStation = Station.from("test2");

    @DisplayName("지하철 노선 이름은 2글자 이상이어야 한다.")
    @Test
    void shorterThanMinLineNameException() {
        final String shortName = "a";
        final double distance = 1;
        final double time = 1;

        assertThrows(ShorterThanMinLineNameException.class,
            () -> Line.of(shortName, upstreamStation, downstreamStation, distance, time));
    }

    @DisplayName("지하철 노선을 생성할 수 있다.")
    @Test
    void create() {
        final double distance = 1;
        final double time = 1;
        final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation, distance, time);

        assertNotNull(line);
    }
}