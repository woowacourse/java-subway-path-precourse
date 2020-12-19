package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.SubwayException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineRepositoryTest {

    @DisplayName("해당 이름을 가진 노선이 없으면 예외 발생")
    @Test
    void findByName() {
        LineRepository.addLine(new Line("2호선"));
        assertThat(LineRepository.findByName("2호선").getName()).isEqualTo("2호선");
        assertThatThrownBy(() -> LineRepository.findByName("신분당선"))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 해당 이름을 가진 노선이 없습니다.");
    }
}