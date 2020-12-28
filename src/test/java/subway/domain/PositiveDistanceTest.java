package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        boolean isPositiveDistance = true;
        try {
            PositiveDistance positiveDistance = new PositiveDistance(0);
        } catch (IllegalArgumentException e) {
            isPositiveDistance = false;
        }
        Assertions.assertFalse(isPositiveDistance);
    }

    @Test
    public void given_minus_1_then_false() {
        boolean isPositiveDistance = true;
        try {
            PositiveDistance positiveDistance = new PositiveDistance(-1);
        } catch (IllegalArgumentException e) {
            isPositiveDistance = false;
        }
        Assertions.assertFalse(isPositiveDistance);
    }
}
