package subway.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    public void isNumeric() {
        assertThat(Validation.isNumeric("1")).isEqualTo(true);
        assertThat(Validation.isNumeric("")).isEqualTo(false);
        assertThat(Validation.isNumeric("number")).isEqualTo(false);
    }
}
