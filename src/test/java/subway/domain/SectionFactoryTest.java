package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.SubwayException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SectionFactoryTest {

    @DisplayName("거리나 도착시간이 양의 정수가 아니면 예외")
    @Test
    void makeSection() {
        Station from = new Station("FROM");
        Station to = new Station("TO");

        assertThat(SectionFactory.makeSection(from, to, 1, 1)).isInstanceOf(Section.class);
        assertThatThrownBy(() -> SectionFactory.makeSection(from, to, 0, -1))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 거리 혹은 시간은 양의 정수여야 합니다.");
    }
}