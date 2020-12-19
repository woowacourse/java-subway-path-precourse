package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TimeTest {

    @Test
    public void testCreate() {
        Time time = Time.newTime(30);
        assertThat(time.getMinute()).isEqualTo(30);
    }

}
