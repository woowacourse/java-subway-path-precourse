package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineRepositoryTest {

    private LineRepository lineRepository;

    private final Line line = LineUtils.getTestInstance();

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository();
    }

    @Test
    @DisplayName("노선 추가 테스트")
    public void addLine_NewLine_LineIsAdded() {

        // when
        lineRepository = lineRepository.addLine(line);

        //then
        assertThat(lineRepository.lines()).containsExactly(line);
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addLine_DuplicateLine_ExceptionThrown() {

        // given
        lineRepository = lineRepository.addLine(line);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> lineRepository.addLine(line);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LineRepository.DUPLICATE_LINE_ERROR);
    }

    @Test
    @DisplayName("노선 삭제 테스트")
    public void deleteLine_OldLine_LineRemoved() {

        // given
        lineRepository = lineRepository.addLine(line);

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
        lineRepository = lineRepository.addLine(line);

        // when
        lineRepository = lineRepository.deleteAll();

        //then
        assertThat(lineRepository.lines()).isEmpty();
    }
}
