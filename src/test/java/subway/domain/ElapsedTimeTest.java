package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ElapsedTimeTest {

    @Test
    @DisplayName("소요 시간 생성 테스트")
    public void create() {
        // given
        int time = 5;

        // when
        ElapsedTime elapsedTime = new ElapsedTime(time);

        //then
        assertThat(elapsedTime.getTime()).isEqualTo(5);
    }

    @Test
    @DisplayName("소요 시간이 음수일 경우 예외 발생 테스트")
    public void create_NegativeTime_ThrownException() {

        // given
        int time = -1;

        // when
        ThrowableAssert.ThrowingCallable callable = () -> new ElapsedTime(time);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(ElapsedTime.NOT_POSITIVE_ERROR);
    }
}
