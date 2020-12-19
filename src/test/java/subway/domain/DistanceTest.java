package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void testCreate() {
        Distance distance = Distance.newDistance(2);
        assertThat(distance.getDistance()).isEqualTo(2);
    }

}
