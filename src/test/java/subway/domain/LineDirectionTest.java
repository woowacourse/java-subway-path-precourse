package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.domain.LineUtils.DISTANCES;
import static subway.domain.LineUtils.STATION_REPOSITORY;

public class LineDirectionTest {

    @Test
    @DisplayName("노선의 역 개수와 거리, 시간의 개수간의 관계가 불일치 할 경우 테스트")
    public void create_IllegalSizeTimes_ExceptionThrown() {

        // given
        ElapsedTimes elapsedTimes = new ElapsedTimes(1);

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> new LineDirection(STATION_REPOSITORY, DISTANCES, elapsedTimes);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LineDirection.NOT_MATCH_SIZE_ERROR);
    }
}
