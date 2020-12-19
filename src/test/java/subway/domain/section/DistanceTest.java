package subway.domain.section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("거리 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitDistance() {
        //given
        int distanceValue = 1;

        //when
        Distance distance = new Distance(distanceValue);

        //then
        assertThat(distance).extracting("distance").isEqualTo(distanceValue);
    }

    @DisplayName("거리의 거리 값이 양수가 아니면 예외를 발생하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, -2, -3, -4
    })
    void testInitDistanceIfDistanceValueIsNotPositiveNumber(int distanceValue) {
        //when
        Distance distance = new Distance(distanceValue);

        //then
        assertThat(distance).extracting("distance").isEqualTo(distanceValue);
    }
}
