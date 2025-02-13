package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LineServiceTest {
    private final LineService lineService = new LineService();

    @Test
    public void addLine() {
        LineDTO lineDTO = new LineDTO("test");
        assertThat(this.lineService.findAll()).hasSize(0);
        this.lineService.addLine(lineDTO);
        assertThat(this.lineService.findAll()).hasSize(1);
    }

    @Test
    public void addLine__AlreadyExistsLineException() {
        LineDTO lineDTO = new LineDTO("test");
        String message = "이미 등록되어있는 노선입니다.";
        this.lineService.addLine(lineDTO);
        assertThatThrownBy(() -> this.lineService.addLine(lineDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void findOneByName() {
        String name = "test";
        LineDTO lineDTO = new LineDTO(name);
        this.lineService.addLine(lineDTO);
        Line line = this.lineService.findOneByName(name);
        assertThat(line.getName()).isEqualTo(name);
    }

    @Test
    public void findOneByName__NotExistsLineException() {
        String message = "존재하지 않은 노선입니다.";
        assertThatThrownBy(() -> this.lineService.findOneByName("test")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.lineService.deleteAll();
    }
}
