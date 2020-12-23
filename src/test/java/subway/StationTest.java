package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.TransitRouteException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StationTest {
    static Station station;

    @DisplayName("이름으로 역을 찾는다.")
    @Test
    void When_기본상태역찾기_Expect_찾기완료() {
        String testName = "사당역";
        assertThat(StationRepository.findStationByName(testName).equals(station));
    }

    @DisplayName("예외 : 이름으로 역을 찾는다.")
    @Test
    void When_존재하지않는역찾기_Expect_예외발생() {
        String testName = "강변역";
        assertThatThrownBy(() -> StationRepository.findStationByName(testName))
                .isInstanceOf(TransitRouteException.class)
                .hasMessage("[ERROR] 해당 역이 존재하지 않습니다");
    }
}
