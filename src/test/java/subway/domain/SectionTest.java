package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SectionTest {
    Station from;
    Station to;

    @BeforeEach
    void setUp() {
        this.from = new Station("FROM");
        this.to = new Station("TO");
    }

    @DisplayName("구간의 이전역을 구한다")
    @Test
    void from() {
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.from()).isEqualTo(new Station("FROM"));
    }

    @DisplayName("구간의 이후역을 구한다")
    @Test
    void to() {
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.to()).isEqualTo(new Station("TO"));
    }

    @DisplayName("구간의 걸리는 시간을 구한다")
    @Test
    void getDistance() {
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.getTakenTime()).isEqualTo(1);
    }

    @DisplayName("구간의 거리를 구한다.")
    @Test
    void getTakenTime() {
        Section section = SectionFactory.makeSection(from, to, 1, 1);
        assertThat(section.getDistance()).isEqualTo(1);
    }
}