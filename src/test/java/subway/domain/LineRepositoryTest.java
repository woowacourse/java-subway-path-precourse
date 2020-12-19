package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository();
    }

    @Test
    @DisplayName("노선 추가 테스트")
    public void addLine_NewLine_LineIsAdded() {

        // given
        Line Line = new Line("2호선");

        // when
        lineRepository = lineRepository.addLine(Line);

        //then
        assertThat(lineRepository.lines()).containsExactly(Line);
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addLine_DuplicateLine_ExceptionThrown() {

        // given
        Line Line = new Line("봉천역");
        lineRepository = lineRepository.addLine(Line);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> lineRepository.addLine(Line);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LineRepository.DUPLICATE_LINE_ERROR);
    }

    @Test
    @DisplayName("여러 노선 추가 테스트")
    public void addLines_NewLines_LinesAreAdded() {

        // given
        String[] lineNames = {"1호선", "2호선", "신분당선"};

        // when
        lineRepository = lineRepository.addLines(lineNames);

        //then
        assertThat(lineRepository.lines()).extracting(Line::getName)
                .containsExactly("1호선", "2호선", "신분당선");
    }

    @Test
    @DisplayName("노선 삭제 테스트")
    public void deleteLine_OldLine_LineRemoved() {

        // given
        Line Line = new Line("2호선");
        lineRepository = lineRepository.addLine(Line);

        // when
        lineRepository = lineRepository.deleteLineByName("2호선");

        //then
        assertThat(lineRepository.lines()).isEmpty();
    }

    @Test
    @DisplayName("존재하지 않는 노선 삭제 시 예외 발생 테스트")
    public void deleteLine_DoesNotExistLine_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> lineRepository.deleteLineByName("2호선");

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LineRepository.NOT_FOUND_STATION_ERROR);
    }

    @Test
    @DisplayName("모든 노선 삭제 테스트")
    public void deleteAll_LineRepository_EmptyLineRepository() {

        // given
        Line line = new Line("2호선");
        lineRepository = lineRepository.addLine(line);

        // when
        lineRepository = lineRepository.deleteAll();

        //then
        assertThat(lineRepository.lines()).isEmpty();
    }
}
