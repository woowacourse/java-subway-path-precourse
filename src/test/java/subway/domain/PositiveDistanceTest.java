package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveDistanceTest {

    @Test
    public void given_1_then_true  () {
        boolean isPositiveDistance = true;
        try {
            PositiveDistance positiveDistance = new PositiveDistance(1);
        } catch (IllegalArgumentException e) {
            isPositiveDistance = false;
        }
        Assertions.assertTrue(isPositiveDistance);
    }

    @Test
    public void given_0_then_false() {
        assertThatThrownBy(() -> new PositiveTime(0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void given_minus_1_then_false() {
        assertThatThrownBy(() -> new PositiveTime(-1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
