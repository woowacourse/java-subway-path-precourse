package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTimeTest {

    @Test
    public void given_1_then_true  () {
        boolean isPositiveTime = true;
        try {
            PositiveTime positiveTime = new PositiveTime(1);
        } catch (IllegalArgumentException e) {
            isPositiveTime = false;
        }
        Assertions.assertTrue(isPositiveTime);
    }

    @Test
    public void given_0_then_false  () {
        assertThatThrownBy(() -> new PositiveTime(0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void given_minus_1_then_false  () {
        assertThatThrownBy(() -> new PositiveTime(-1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
