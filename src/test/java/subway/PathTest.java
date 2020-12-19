package subway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Path;
import subway.domain.Station;
import subway.domain.StationsInLine;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static resource.TextResource.ERROR_DISTANCE_TIME_NOT_POSITIVE;
import static resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

public class PathTest {
    @BeforeAll
    public static void init() {
        Application.init();
    }

    @Test
    @DisplayName("거리와 소요시간은 양의 정수이다.")
    public void checkDistanceAndTimePositive() {
        assertThatThrownBy(() -> {
            Path path = new Path(-1, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_DISTANCE_TIME_NOT_POSITIVE);

        assertThatThrownBy(() -> {
            Path path = new Path(0, -1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_DISTANCE_TIME_NOT_POSITIVE);

        assertThatThrownBy(() -> {
            Path path = new Path(-1, -1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_DISTANCE_TIME_NOT_POSITIVE);
    }
}
