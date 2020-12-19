package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    @DisplayName("구간의 이전역을 구한다")
    @Test
    void from() {
        Station from = new Station("FROM");
        Station to = new Station("TO");
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.from()).isEqualTo(new Station("FROM"));
    }

    @DisplayName("구간의 이후역을 구한다")
    @Test
    void to() {
        Station from = new Station("FROM");
        Station to = new Station("TO");
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.to()).isEqualTo(new Station("TO"));
    }
}