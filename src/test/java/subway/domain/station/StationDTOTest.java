package subway.domain.station;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StationDTOTest {
    @Test
    public void constructor__StationNameEssentialException() {
        String message = "역 이름은 필수입니다.";
        assertThatThrownBy(() -> new StationDTO(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new StationDTO("")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
