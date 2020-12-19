package subway.domain;

import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.domain.LineUtils.DISTANCES;
import static subway.domain.LineUtils.LINE_DIRECTION;
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

    @Test
    @DisplayName("노선이 가지고 있는 역 반환 테스트")
    public void getStationNames_LineDirection() {

        // when
        List<String> stationNames = LINE_DIRECTION.getStationNames();

        //then
        assertThat(stationNames).containsExactly("봉천역", "신림역", "신대방역");
    }

    @Test
    @DisplayName("노선이 가지고 있는 거리들 반환 테스트")
    public void getDistances_LineDirection() {

        // when
        List<Integer> distances = LINE_DIRECTION.getDistances();

        //then
        assertThat(distances).containsExactly(1, 2);
    }

    @Test
    @DisplayName("노선이 가지고 있는 소요 시간들 반환 테스트")
    public void getElapsedTimes_LineDirection() {

        // when
        List<Integer> elapsedTimes = LINE_DIRECTION.getElapsedTimes();

        //then
        assertThat(elapsedTimes).containsExactly(5, 10);
    }
}
