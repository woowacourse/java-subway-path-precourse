package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {
    @Test
    public void exists() {
        Line line = new Line("test");
        assertThat(LineRepository.exists(line)).isEqualTo(false);
        LineRepository.addLine(line);
        assertThat(LineRepository.exists(line)).isEqualTo(true);
    }

    @Test
    public void findByName() {
        String name = "test";
        Line line = new Line(name);
        assertThat(LineRepository.findByName(name)).isNotPresent();
        LineRepository.addLine(line);
        assertThat(LineRepository.findByName(name)).isPresent();
    }

    @AfterEach
    public void init() {
        LineRepository.deleteAll();
    }
}
