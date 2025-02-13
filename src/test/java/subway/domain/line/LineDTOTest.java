package subway.domain.line;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LineDTOTest {
    @Test
    public void constructor__LineNameEssentialException() {
        String message = "노선 이름은 필수입니다.";
        assertThatThrownBy(() -> new LineDTO(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new LineDTO("")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
