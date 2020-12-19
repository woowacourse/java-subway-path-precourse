package subway.domain.line;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.domain.Line;
import subway.domain.line.domain.LineRepository;
import subway.domain.line.exception.CannotFindLineByNameException;
import subway.domain.line.exception.DuplicateLineNameException;
import subway.domain.station.domain.Station;

@DisplayName("지하철 노선 관리 기능을 테스트 한다.")
class LineRepositoryTest {

    final String LINE_NAME = "test line";
    final int LINE_SIZE = 1;
    final double DISTANCE = 1;
    final double TIME = 1;
    final Station upstreamStation = Station.from("test station1");
    final Station downstreamStation = Station.from("test station2");
    final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation, DISTANCE, TIME);

    @BeforeEach
    void before() {
        LineRepository.save(line);
    }

    @AfterEach
    void after() {
        LineRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 노선 이름은 등록될 수 없다.")
    @Test
    void duplicateLineNameException() {
        assertThrows(DuplicateLineNameException.class, () -> LineRepository.save(line));
    }

    @DisplayName("지하철 노선 저장소에 지하철 노선을 등록할 수 있다.")
    @Test
    void addLine() {
        final String NAME = "test";
        final double distance = 1;
        final double time = 1;
        final Line line = Line.of(NAME, upstreamStation, downstreamStation, distance, time);

        LineRepository.save(line);

        final int EXPECT = LINE_SIZE + 1;
        assertEquals(LineRepository.findAll().size(), EXPECT);
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선의 목록을 조회할 수 있다.")
    @Test
    void findAllLine() {
        final List<Line> lines = LineRepository.findAll();

        assertEquals(lines.size(), LINE_SIZE);
    }

    @DisplayName("등록되지 않은 지하철 노선은 조회할 수 없다.")
    @Test
    void cannotFindLineByNameException() {
        final String TARGET = "test";

        assertThrows(CannotFindLineByNameException.class, () -> LineRepository.findByName(TARGET));
    }

    @DisplayName("지하철 노선 저장소에 존재하는 지하철 노선을 이름으로 조회할 수 있다.")
    @Test
    void findLineByName() {
        final Line foundLine = LineRepository.findByName(LINE_NAME);

        assertSame(foundLine, line);
    }
}