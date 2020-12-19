package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {

    @Test
    @DisplayName("Distance 객체 생성 테스트")
    public void create_AnyDistance_NewInstance() {

        // when
        Distance distance = new Distance(2);

        //then
        assertThat(distance.getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("역 사이의 거리가 양의 정수가 아닐 경우 예외 발생")
    public void create_NegativeNumber_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable = () -> new Distance(-1);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(Distance.NOT_POSITIVE_ERROR);
    }
}
