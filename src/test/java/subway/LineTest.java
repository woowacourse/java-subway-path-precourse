package subway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationsInLine;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

public class LineTest {

    @BeforeAll
    public static void init() {
        Application.init();
    }

    @Test
    @DisplayName("지하철 노선은 생성 시 상행 종점역과 하행 종점역이 같을 수 없다.")
    public void checkDuplicatedStationInLineConstructor() {
        assertThatThrownBy(() -> {
            LinkedList<Station> stations = new LinkedList<>();
            stations.addFirst(new Station("교대역"));
            stations.addLast(new Station("교대역"));
            StationsInLine stationsInLine = new StationsInLine(stations);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_START_END_STATION_DUPLICATED);
    }
}
