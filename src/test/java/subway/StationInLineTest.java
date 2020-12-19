package subway;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static resource.TextResource.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.*;

public class StationInLineTest {

    @BeforeAll
    public static void init() {
        Application.init();
    }

    @Test
    @DisplayName("지하철 노선은 중복된 역을 추가 할 수 없다.")
    public void checkDuplicatedStationInLineAdd() {
        assertThatThrownBy(() -> {
            Line line = LineRepository.getLineByName("2호선");
            Station station = StationRepository.getStationByName("역삼역");
            line.addStation(station, 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_STATION_DUPLICATED_IN_SECTION);
    }

    @Test
    @DisplayName("노선에 역 추가 시 입력된 순서는 1(상행 종점) 이상 등록된 구간의 사이즈 + 1 (하행 종점 뒤에 등록하기 위해) 이하 여야 한다. ")
    public void checkPositionInSection() {
        Line line = LineRepository.getLineByName("2호선");
        Station station = StationRepository.getStationByName("매봉역");
        assertThatThrownBy(() -> {
            line.addStation(station, 5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_STATION_ORDER_NOT_VALID);

        assertThatThrownBy(() -> {
            line.addStation(station, 0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_STATION_ORDER_NOT_VALID);
    }
}
