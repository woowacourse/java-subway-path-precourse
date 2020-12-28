package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        boolean isPositiveTime = true;
        try {
            PositiveTime positiveTime = new PositiveTime(0);
        } catch (IllegalArgumentException e) {
            isPositiveTime = false;
        }
        Assertions.assertFalse(isPositiveTime);
    }

    @Test
    public void given_minus_1_then_false  () {
        boolean isPositiveTime = true;
        try {
            PositiveTime positiveTime = new PositiveTime(-1);
        } catch (IllegalArgumentException e) {
            isPositiveTime = false;
        }
        Assertions.assertFalse(isPositiveTime);
    }

}
